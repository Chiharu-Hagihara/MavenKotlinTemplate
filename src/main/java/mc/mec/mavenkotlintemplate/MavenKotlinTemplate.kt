package mc.mec.mavenkotlintemplate

import mc.mec.mavenkotlintemplate.commands.HovertextCommand
import mc.mec.mavenkotlintemplate.commands.MavenCommand
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.ComponentBuilder
import net.md_5.bungee.api.chat.HoverEvent
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class MavenKotlinTemplate : JavaPlugin() {
    override fun onEnable() { // Plugin startup logic
        logger.info("HelloWorld!")

        getCommand("maven")?.setExecutor(MavenCommand)
        getCommand("hovertext")?.setExecutor(HovertextCommand)
    }

    override fun onDisable() { // Plugin shutdown logic
    }

    //  マインクラフトチャットに、ホバーテキストや、クリックコマンドを設定する関数
    // [例1] sendHoverText(player,"ここをクリック",null,"/say test")
    // [例2] sendHoverText(player,"カーソルをあわせて","ヘルプメッセージとか",null)
    // [例3] sendHoverText(player,"カーソルをあわせてクリック","ヘルプメッセージとか","/say test")
    fun sendHoverText(p: Player?, text: String, hoverText: String, command: String) {
        //////////////////////////////////////////
        //      ホバーテキストとイベントを作成する
        val hoverEvent = HoverEvent(HoverEvent.Action.SHOW_TEXT, ComponentBuilder(hoverText).create())

        //////////////////////////////////////////
        //   クリックイベントを作成する
        val clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, "/$command")
        val message = ComponentBuilder(text).event(hoverEvent).event(clickEvent).create()
        p?.spigot()?.sendMessage(*message)
    }
}