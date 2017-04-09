package com.angkorteam.finance.server;

import com.angkorteam.framework.jdbc.InsertQuery;
import com.angkorteam.framework.spring.JdbcNamed;
import com.angkorteam.framework.spring.JdbcTemplate;
import org.apache.commons.configuration.XMLPropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 * Created by socheatkhauv on 27/1/17.
 */
public abstract class Platform {

    public static final String PATTERN_DATETIME = "pattern.datetime";
    public static final String PATTERN_TIME = "pattern.time";
    public static final String PATTERN_DATE = "pattern.date";
    public static final String PATTERN_FOLDER = "pattern.folder";

    public static final String ENCRYPTION_PASSWORD = "encryption.password";
    public static final String ENCRYPTION_OUTPUT = "encryption.output";
    public static String WICKET = "wicket";

    public static final String RESOURCE_REPO = "resource.repo";

    private static ServletContext servletContext;

    public static <T> T getBean(String name, Class<T> requiredType) {
        if (servletContext == null) {
            servletContext = WebApplication.get().getServletContext();
        }
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        return applicationContext.getBean(name, requiredType);
    }


    public static <T> T getBean(Class<T> requiredType) {
        if (servletContext == null) {
            servletContext = WebApplication.get().getServletContext();
        }
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        Map<String, T> beans = applicationContext.getBeansOfType(requiredType);
        if (beans == null || beans.isEmpty()) {
            return null;
        }
        if (beans.size() == 1) {
            for (Map.Entry<String, T> bean : beans.entrySet()) {
                return bean.getValue();
            }
        } else {
            for (Map.Entry<String, T> bean : beans.entrySet()) {
                if (bean.getKey().equalsIgnoreCase(requiredType.getSimpleName())) {
                    return bean.getValue();
                }
            }
        }
        return null;
    }

    public static void saveFile(String requestId, File file, String clientFilename) {
        JdbcNamed named = Platform.getBean(JdbcNamed.class);

        XMLPropertiesConfiguration configuration = Platform.getBean(XMLPropertiesConfiguration.class);

        String patternFolder = configuration.getString(PATTERN_FOLDER);

        String repo = configuration.getString(RESOURCE_REPO);

        String fileRepo = DateFormatUtils.format(new Date(), patternFolder);
        File container = new File(repo, fileRepo);
        String extension = StringUtils.lowerCase(FilenameUtils.getExtension(file.getName()));


        String uuid = Platform.uuid();
        String name = uuid + "." + extension;
        container.mkdirs();
        try {
            FileUtils.copyFile(file, new File(container, name));
        } catch (Exception e) {
        }

        String fileId = Platform.uuid();
        InsertQuery insertQuery = new InsertQuery("file");
        insertQuery.addValue("file_id = :file_id", fileId);
        insertQuery.addValue("request_id = :request_id", requestId);
        insertQuery.addValue("created_on = :created_on", new Date());
        insertQuery.addValue("size = :size", file.length());
        insertQuery.addValue("path = :path", fileRepo);
        insertQuery.addValue("server_filename = :server_filename", file.getName());
        insertQuery.addValue("client_filename = :client_filename", clientFilename);
        named.update(insertQuery.toSQL(), insertQuery.getParam());
    }

    public static String uuid() {
        JdbcTemplate jdbcTemplate = Platform.getBean(JdbcTemplate.class);
        return jdbcTemplate.queryForObject("select uuid() from dual", String.class);
    }

}
