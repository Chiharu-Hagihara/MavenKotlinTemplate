package mc.mec.mavenkotlintemplate.commands

import mc.mec.mavenkotlintemplate.MavenKotlinTemplate
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object MavenCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        sender.sendMessage("Hello Maven!")
        return true
    }

}