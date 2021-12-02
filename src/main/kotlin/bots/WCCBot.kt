package bots

import BOT_TOKEN
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import java.io.File

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
        val messageCommand: String? = update?.message?.text

        val welcomeMessage = """
        *Olá $nameSander\!*        
        *Sou Fabiana, Consultora Natura\.*          
        *Como posso ajudar\?* 
        *O menu abaixo pode ser muito útil para que você encontre o que deseja\:*  
        
        *Visite o site Natura comigo\:*   
        \/espacoNatura
        *Os destaques do momento\:*    
        \/promocoes         
        *Muitas opçoes de presentes\:*
        \/presentes
        *Natura de A a Z\:*
        \/marcas        
        *De Ekos a Plant\:*
        \/cabelos
        *De Biografia a Sève\:*
        \/corpoebanho
        *De Faces a Una\:*
        \/maquiagem        
        *De Águas a Sintonia\:*
        \/perfumaria
        *De Chronos a Fotoequilíbrio\:*
        \/rosto
        *Puro vegetal é aqui\:*
        \/veganos     
        *Como comprar no App\(aguarde carregar\)\:*
        \/comprarNoApp
        *Baixe o App Natura\:*
        \/baixarApp
         """.trimIndent()

        val sendDocument = SendDocument()

        try {

            when (messageCommand) {
                "/espacoNatura" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption = "Visite meu Espaço Natura: https://www.natura.com.br/consultoria/fabianamfarias"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/1Zn1NsJszRNXoeILQg/giphy.gif")
                    }
                    execute(sendDocument)
                }

                "/promocoes" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption = "Tudo em promoções: https://www.natura.com.br/c/tudo-em-promocoes"
                        this.document = InputFile().setMedia("https://images.rede.natura.net/html/crm/campanha/20190601/N__PRECOS_APAIXONANTES_20190601_01.gif")
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

                "/marcas" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption =
                            "As queridinhas do Brasil: https://www.natura.com.br/nossas-marcas?consultoria=fabianamfarias"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/6LSwbG3ou2AF21b7rl/giphy.gif")
                    }
                    execute(sendDocument)
                }

                "/corpoebanho" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption =
                            "Tudo em corpo e banho: https://www.natura.com.br/c/tudo-em-corpo-e-banho?consultoria=fabianamfarias"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/1ieJq6mtNB4g5eXru3/giphy.gif")
                    }
                    execute(sendDocument)
                }
                "/cabelos" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption =
                            "Tudo em cabelos: https://www.natura.com.br/c/tudo-em-cabelos?consultoria=fabianamfarias"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/fzub3vneXmvx6/giphy.gif")
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

                "/perfumaria" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption = "Tudo em perfumaria: https://www.natura.com.br/c/tudo-em-perfumaria"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/jRZXphYJNLtdEeYJBO/giphy.gif")
                    }
                    execute(sendDocument)
                }

                "/rosto" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption =
                            "Tudo em rosto: https://www.natura.com.br/c/tudo-em-rosto?consultoria=fabianamfarias"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/1zKeF9nmjUVGLst2oU/giphy.gif")
                    }
                    execute(sendDocument)
                }

                "/veganos" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption = "Nossos produtos veganos: https://www.natura.com.br/s/produtos?busca=%22veganos%22"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/1BfwFBvHXH6QGRcRyd/giphy.gif")
                    }
                    execute(sendDocument)
                }


                "/comprarNoApp" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption = "Saiba como comprar pelo App Natura"
                        this.document = InputFile().setMedia(File("/home/ffarias/IdeaProjects/wcc-kotlin-telegram-bot/src/main/resources/baixarNaturaApp.mp4"))
                    }
                    execute(sendDocument)
                }

                "/baixarApp" -> {
                    sendDocument.apply {
                        this.chatId = chatId
                        this.caption =
                            "Baixe aqui o App Natura: https://play.google.com/store/apps/details?id=net.natura.semprepresente&hl=en_US&gl=US"
                        this.document =
                            InputFile().setMedia("https://media.giphy.com/media/A7vxv9C9dqTgSnOubO/giphy.gif")
                    }
                    execute(sendDocument)
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
