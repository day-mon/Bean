package at.xirado.bean.backend.routes;

import at.xirado.bean.Bean;
import at.xirado.bean.backend.WebServer;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.apache.http.client.utils.URIBuilder;
import spark.Request;
import spark.Response;

import java.net.URISyntaxException;

public class GetInviteURL
{
    public static final String HOST = "discord.com";

    public static Object handle(Request request, Response response) throws URISyntaxException
    {
        URIBuilder builder = new URIBuilder()
                .setScheme("https")
                .setHost(HOST)
                .setPath("/oauth2/authorize")
                .addParameter("client_id", Bean.getInstance().getWebServer().getClientId())
                .addParameter("scope", "bot applications.commands")
                .addParameter("permissions", "2080899263");
        return DataObject.empty()
                .put("url", builder.build().toString())
                .toString();
    }

    public static String getInviteURL()
    {
        try
        {
            URIBuilder builder = new URIBuilder()
                    .setScheme("https")
                    .setHost(HOST)
                    .setPath("/oauth2/authorize")
                    .addParameter("client_id", Bean.getInstance().getWebServer().getClientId())
                    .addParameter("scope", "bot applications.commands")
                    .addParameter("permissions", "2080899263");
            return builder.build().toString();
        } catch (Exception ex)
        {
            return null;
        }
    }
}
