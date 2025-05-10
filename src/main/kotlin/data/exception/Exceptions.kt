package data.exception

class UnAuthorizedException(message: String): Exception(message)

class NotFoundException(message: String) : Exception(message)

class ServerErrorException(message: String) : Exception(message)

class UnknownApiException(message: String) : Exception(message)
