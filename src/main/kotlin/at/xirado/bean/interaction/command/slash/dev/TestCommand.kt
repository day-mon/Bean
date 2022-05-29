package at.xirado.bean.interaction.command.slash.dev

import at.xirado.bean.Application
import at.xirado.bean.getData
import at.xirado.bean.interaction.SlashCommand
import dev.minn.jda.ktx.await
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent

class TestCommand(override val application: Application) : SlashCommand("test", "This is a test command") {

    init {
        devCommand()
    }

    override suspend fun execute(event: SlashCommandInteractionEvent) {
        val guildData = event.guild?.getData()?: return event.reply("Nothing found :(").queue()

        event.reply(guildData.jsonObject.toPrettyString()).await()
    }
}