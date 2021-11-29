package bots

import BOT_TOKEN
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
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

    private val sendDocument = SendDocument()
    private val sendMessage = SendMessage()

    override fun onUpdateReceived(update: Update?) {
        // We check if the update has a message and the message has text
        val chatId = update?.message?.chatId.toString()
        val nameSander = update?.message?.from?.firstName
        val messageCommand: String? = update?.message?.text?.lowercase()

        try {

            when (messageCommand) {
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
                            InputFile().setMedia("https://media.giphy.com/media/5BFIypSRBD907oPHuB/giphy.gif")
                    }
                    execute(sendDocument)
                }

                else -> {
                    val sendDocument = SendDocument().apply {
                        this.chatId = chatId
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/2oUfJzyXFg6FVgqU0i/giphy.gif")
                    }
                    execute(sendDocument)

                    sendMessage.apply {
                        this.chatId = chatId
                        this.text = """
                    *Olá $nameSander\!*
                    *Em que posso te ajudar\?*
                    *Escolha na lista abaixo\:*
                                        
                    /promocoes
                     /presentes
                     /perfumaria
                     /corpoebanho
                     /cabelos
                     /rosto
                     /maquiagem
                     /marcas
                     /destaques
                        """.trimIndent()
                        this.parseMode = "MarkDownV2"
                    }
                    execute(sendMessage)
                }
            }
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }
}
