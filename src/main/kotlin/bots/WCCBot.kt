package bots

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.methods.send.SendMessage

import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

class WCCBot : TelegramLongPollingBot() {


    override fun getBotUsername(): String {
        //return bot username
        // If bot username is @HelloKotlinBot, it must return
        return "@secuide_bot"
    }

    // Add our bot to a channel


    override fun getBotToken(): String {
        // Return bot token from BotFather
        return "2138831054:AAH0bI1F6pq4pRM9X0oHpDXE60JYfw0XC7E"
    }

    override fun onUpdateReceived(update: Update?) {
        // We check if the update has a message and the message has text
        val chatId = update?.message?.chatId.toString()
        val nameSander = update?.message?.from?.firstName
        val messageCommand = update?.message?.text?.lowercase()

        try {

            if (messageCommand == "/promocoes"){

                val sendMessage = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = "Tudo em promoções: https://www.natura.com.br/c/tudo-em-promocoes"
                    this.document = InputFile().setMedia("https://abre.ai/dx9O")
                }
                execute(sendMessage)

            } else if(messageCommand == "/presentes") {

                val sendMessage = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = "Tudo em presentes: https://www.natura.com.br/c/tudo-em-presentes"
                    this.document = InputFile().setMedia("https://abre.ai/dx8Z")
                }
                execute(sendMessage)
            }
            else if(messageCommand == "/perfumaria") {

            val sendMessage = SendDocument().apply {
                this.chatId = chatId
                this.caption = "Tudo em perfumaria: https://www.natura.com.br/c/tudo-em-perfumaria"
                this.document = InputFile().setMedia("https://abre.ai/dx89")
            }
            execute(sendMessage)
            }
            else if(messageCommand == "/corpoebanho") {

                val sendMessage = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = "Tudo em corpo e banho: https://www.natura.com.br/c/tudo-em-corpo-e-banho?consultoria=fabianamfarias"
                    this.document = InputFile().setMedia("https://abre.ai/dx9k")
                }
                execute(sendMessage)
            }
            else if(messageCommand == "/cabelos") {

                val sendMessage = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = "Tudo em cabelos: https://www.natura.com.br/c/tudo-em-corpo-e-banho?consultoria=fabianamfarias"
                    this.document = InputFile().setMedia("https://abre.ai/dx9D")
                }
                execute(sendMessage)
            }
            else if(messageCommand == "/rosto") {

                val sendMessage = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = "Tudo em rosto: https://www.natura.com.br/c/tudo-em-rosto?consultoria=fabianamfarias"
                    this.document = InputFile().setMedia("https://abre.ai/dx9F")
                }
                execute(sendMessage)
            }
            else if(messageCommand == "/maquiagem") {

                val sendMessage = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = "Tudo em maquiagem: https://www.natura.com.br/c/tudo-em-maquiagem?consultoria=fabianamfarias"
                    this.document = InputFile().setMedia("https://abre.ai/dx9T")
                }
                execute(sendMessage)
            }

            else if(messageCommand == "/marcas") {

                val sendMessage = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = "Nossas marcas: https://www.natura.com.br/nossas-marcas?consultoria=fabianamfarias"
                    this.document = InputFile().setMedia("https://abre.ai/dx9J")
                }
                execute(sendMessage)
            }

            else if(messageCommand == "/destaques") {

                val sendMessage = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = "Destaques de consultoria: https://www.natura.com.br/c/destaques?consultoria=fabianamfarias"
                    this.document = InputFile().setMedia("https://abre.ai/dx8P")
                }
                execute(sendMessage)
            }

            else {
                val sendMessage = SendMessage().apply {
                    this.chatId = chatId
                    this.text = """
                    *Olá $nameSander\!*
                    *O que você procura?*
                    *Escolha uma das opções abaixo\:*

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
                    this.parseMode  = "MarkDownV2"
                }
                execute(sendMessage)
            }
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }
}

