import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def query = message.getHeader("CamelHttpQuery", String)

    def params = [:]

    query.split("&").each {
        def pair = it.split("=")
        if (pair.size() == 2) {
            params[pair[0]] = pair[1]
        }
    }

    message.setProperty("from", params["from"])
    message.setProperty("to", params["to"])

    return message
}