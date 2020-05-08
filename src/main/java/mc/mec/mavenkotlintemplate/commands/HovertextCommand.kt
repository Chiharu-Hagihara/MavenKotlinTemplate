package mc.mec.mavenkotlintemplate.commands

import mc.mec.mavenkotlintemplate.MavenKotlinTemplate
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HovertextCommand(private val pl: MavenKotlinTemplate) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val p = sender as? Player
        if (p != null) {
            pl.sendHoverText(p, "[ここをクリック！]", "ここをクリックしてください。", "/say HoverTextはちゃんと動いてるよ。")
        }
        return true
    }
}