package mc.mec.mavenkotlintemplate

import mc.mec.mavenkotlintemplate.commands.HovertextCommand
import mc.mec.mavenkotlintemplate.commands.MavenCommand
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.ComponentBuilder
import net.md_5.bungee.api.chat.HoverEvent
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class MavenKotlinTemplate : JavaPlugin(), Listener {
    companion object{
        lateinit var pl:MavenKotlinTemplate
    }

    override fun onEnable() { // Plugin startup logic
        logger.info("HelloWorld!")

        pl = this
        getCommand("maven")?.setExecutor(MavenCommand)
        getCommand("hovertext")?.setExecutor(HovertextCommand(this))
    }

    override fun onDisable() { // Plugin shutdown logic
    }

    //  マインクラフトチャットに、ホバーテキストや、クリックコマンドを設定する関数
    // [例1] sendHoverText(player,"ここをクリック",null,"/say test")
    // [例2] sendHoverText(player,"カーソルをあわせて","ヘルプメッセージとか",null)
    // [例3] sendHoverText(player,"カーソルをあわせてクリック","ヘルプメッセージとか","/say test")
    fun sendHoverText(p: Player, text: String?, hoverText: String?, command: String?) {
        //////////////////////////////////////////
        //      ホバーテキストとイベントを作成する
        var hoverEvent: HoverEvent? = null
        if (hoverText != null) {
            val hover = ComponentBuilder(hoverText).create()
            hoverEvent = HoverEvent(HoverEvent.Action.SHOW_TEXT, hover)
        }

        //////////////////////////////////////////
        //   クリックイベントを作成する
        var clickEvent: ClickEvent? = null
        if (command != null) {
            clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, command)
        }
        val message = ComponentBuilder(text).event(hoverEvent).event(clickEvent).create()
        p.spigot().sendMessage(*message)
    }
}