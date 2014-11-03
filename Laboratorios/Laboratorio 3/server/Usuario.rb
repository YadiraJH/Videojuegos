require "rubygems"

class Usuario
  @@dirIzq = "izquierda"
  @@dirDer = "derecha"
  @@dirNone = "ninguna"
  
  def dirIzq
    @@dirIzq
  end
  
  def dirDer
    @@dirDer
  end
  
  def dirNone
    @@dirNone
  end
  
  def initialize(usu,tieneAvatar)
    @idUsu = usu
    @dirAvatar = @@dirNone
    @hasAvatar = tieneAvatar
  end
  
  def getIdUsuario
  	return @idUsu
  end
  
  def getDirAvatar
  	return @dirAvatar
  end
  
  def setDirAvatar(dirAva)
  	@dirAvatar = dirAva
  end
  
  def getHasAvatar
  	return @hasAvatar
  end
  
  def setHasAvatar(tieneAva)
  	@hasAvatar = tieneAva
  end
end