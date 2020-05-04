package mc.mec.mavenkotlintemplate.commands

import mc.mec.mavenkotlintemplate.MavenKotlinTemplate
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object HovertextCommand: CommandExecutor {
    val pl = MavenKotlinTemplate()
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        pl.sendHoverText(sender as? Player, "[ここをクリック！]","ここをクリックしてください。", "/say HoverTextはちゃんと動いてるよ。")
        return true
    }
}