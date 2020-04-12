package mc.mec.mavenkotlintemplate

import mc.mec.mavenkotlintemplate.commands.MavenCommand
import org.bukkit.plugin.java.JavaPlugin

class MavenKotlinTemplate : JavaPlugin() {
    override fun onEnable() { // Plugin startup logic
        logger.info("HelloWorld!")

        getCommand("maven")?.setExecutor(MavenCommand)
    }

    override fun onDisable() { // Plugin shutdown logic
    }
}