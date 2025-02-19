package at.xirado.bean.command.terminal;

import at.xirado.bean.Bean;
import at.xirado.bean.command.ConsoleCommand;
import at.xirado.bean.log.Shell;
import net.dv8tion.jda.api.JDAInfo;

import java.util.Arrays;

public class Info extends ConsoleCommand {

    public Info() {
        this.invoke = "info";
        this.description = "Shows logo and information";
        this.aliases = Arrays.asList("about", "information");
    }

    @Override
    public void executeCommand(String invoke, String[] args) {
        String logo = Shell.getLogo();
        StringBuilder sb = new StringBuilder();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        sb.append("\nBean version ").append(Bean.getBeanVersion()).append("\nJDA ").append(JDAInfo.VERSION + " (" + JDAInfo.GITHUB + ")");
        sb.append("\nmemory info:\n")
                .append("   max memory:       ").append(convertBytes(Runtime.getRuntime().maxMemory())).append("\n")
                .append("   allocated memory: ").append(convertBytes(Runtime.getRuntime().totalMemory())).append("\n")
                .append("   free memory:      ").append(convertBytes(Runtime.getRuntime().freeMemory())).append("\n")
                .append("   used memory:      ").append(convertBytes(usedMemory)).append("\n");
        System.out.println("\n" + logo + sb);
    }


    public static String convertBytes(long bytes) {
        if (bytes < 1024) return bytes + " bytes";
        if (bytes < 1048576) return bytes / 1024 + " kB";
        if (bytes < 1073741824) return (bytes / 1024) / 1024 + " MB";
        return ((bytes / 1024) / 1024) / 1024 + " GB";
    }

}
