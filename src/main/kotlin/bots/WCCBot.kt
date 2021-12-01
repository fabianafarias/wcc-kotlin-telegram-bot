package bots

import BOT_TOKEN
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.methods.send.SendVideo
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

class WCCBot : TelegramLongPollingBot() {

    override fun getBotUsername(): String {
        // return bot username
        // If bot username is @HelloKotlinBot, it must return
        return "@consultoraNatura_bot"
    }

    override fun getBotToken(): String {
        // Return bot token from BotFather
        return BOT_TOKEN
    }

    override fun onUpdateReceived(update: Update?) {
        // We check if the update has a message and the message has text
        val chatId = update?.message?.chatId.toString()
        val nameSander = update?.message?.from?.firstName
        val messageCommand: String? = update?.message?.text?.lowercase()

        val sendDocument = SendDocument()
        val sendVideo= SendVideo()

        val welcomeMessage = """
        *Olá $nameSander\!*
        *Sou Fabiana, sua Consultora Natura\.*
        *Se quiser ir direto para o site Natura, escolha a primeira opção do menu "/espacoNatura"*
        
        \/espacoNatura \- Visite meu espaço no portal da Natura        
        \/promocoes \- Promoções no site Natura
        \/presentes \- Presentes no site Natura
        \/perfumaria \- Perfumaria no site Natura
        \/corpoebanho \- Corpo e Banho no site Natura
        \/cabelos \- Cabelos no site Natura
        \/rosto \- Rosto no site Natura
        \/maquiagem \- Maquiagem no site Natura
        \/marcas \- Marcas no site Natura
        \/destaques \- Destaques no site Natura
        \/baixarApp \- Baixe o App Natura
        \/comprandoNoApp \- Como comprar pelo App
         """.trimIndent()

        try {

            when (messageCommand) {
                "/espacoNatura" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption = "Meu espaço Natura: https://www.natura.com.br/consultoria/fabianamfarias"
                        this.document = InputFile().setMedia("https://media.giphy.com/media/5BFIypSRBD907oPHuB/giphy.gif")
                    }
                    execute(sendDocument)
                }
                "/promocoes" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption = "Tudo em promoções: https://www.natura.com.br/c/tudo-em-promocoes"
                        this.document = InputFile().setMedia("https://abre.ai/dycD")
                    }
                    execute(sendDocument)
                }
                "/presentes" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption = "Tudo em presentes: https://www.natura.com.br/c/tudo-em-presentes"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/MUxetIxoAhsLgb6UD0/giphy.gif")
                    }
                    execute(sendDocument)
                }
                "/perfumaria" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption = "Tudo em perfumaria: https://www.natura.com.br/c/tudo-em-perfumaria"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/jRZXphYJNLtdEeYJBO/giphy.gif")
                    }
                    execute(sendDocument)
                }
                "/corpoebanho" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption =
                            "Tudo em corpo e banho: https://www.natura.com.br/c/tudo-em-corpo-e-banho?consultoria=fabianamfarias"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/1BfwFBvHXH6QGRcRyd/giphy.gif")
                    }
                    execute(sendDocument)
                }
                "/cabelos" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption =
                            "Tudo em cabelos: https://www.natura.com.br/c/tudo-em-corpo-e-banho?consultoria=fabianamfarias"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/kHOANJDT1HJV6JhbKm/giphy.gif")
                    }
                    execute(sendDocument)
                }
                "/rosto" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption =
                            "Tudo em rosto: https://www.natura.com.br/c/tudo-em-rosto?consultoria=fabianamfarias"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/YlmliMCSLsCwOsafyY/giphy.gif")
                    }
                    execute(sendDocument)
                }
                "/maquiagem" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption =
                            "Tudo em maquiagem: https://www.natura.com.br/c/tudo-em-maquiagem?consultoria=fabianamfarias"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/5zjdEUp4UrO8VsIhHK/giphy.gif")
                    }
                    execute(sendDocument)
                }
                "/marcas" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption =
                            "Nossas marcas: https://www.natura.com.br/nossas-marcas?consultoria=fabianamfarias"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/hMcwSWaRU3XyT8wdxp/giphy.gif")
                    }
                    execute(sendDocument)
                }
                "/destaques" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption =
                            "Destaques de consultoria: https://www.natura.com.br/c/destaques?consultoria=fabianamfarias"
                        this.document =
                            InputFile().setMedia("")
                    }
                    execute(sendDocument)
                }

                "/baixarApp" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption =
                            "Baixe aqui o App Natura: https://www.play.google.com/store/apps/details?id=net.natura.semprepresente&referrer=utm_source%3Drede_natura_mobile%26utm_medium%3Dbotao_google_play"
                        this.document =
                            InputFile().setMedia("")
                        this.parseMode = "MarkDownV2"
                    }
                    execute(sendDocument)
                }
                "/comprandoNoApp" -> {
                    sendVideo.apply {
                        this.chatId = chatId
                        this.video = InputFile().setMedia(java.io.File("src/main/resources/naturaApp.mp4"))
                        this.caption = "Aprenda como usar o app Natura"
                        this.parseMode = "MarkDownV2"
                    }
                    execute(sendVideo)
                }

                else -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption = welcomeMessage
                        this.document = InputFile().setMedia("https://media.giphy.com/media/2oUfJzyXFg6FVgqU0i/giphy.gif")
                        this.parseMode = "MarkDownV2"
                        }
                        execute(sendDocument)
                    }

                }

        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }
}
