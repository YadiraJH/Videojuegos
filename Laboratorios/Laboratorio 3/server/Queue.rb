require "rubygems"
require './Usuario'

class Queue
  def init
    @store = []
  end
  
  def dequeueAndQueue(dir)
  	if(@store != [] && @store != nil)
  		if(self.size>0)
  			usu = @store.first
  			@store.shift
  			if(usu.getHasAvatar)
  				usu2 = @store.first
  				dirAux = ""
  				if(usu!=nil)
  					usu2.setHasAvatar(true)
  					if(dir == usu.dirIzq)
  						dirAux = usu2.dirDer
  					elsif (dir == usu2.dirDer)
  						dirAux = usu2.dirIzq
  					else
  						dirAux = usu2.dirNone
  					end
  					usu2.setDirAvatar(dirAux)
  				end
  				usu.setDirAvatar(usu.dirNone)
  				usu.setHasAvatar(false)
  				@store << usu
  				return dirAux
  			end
    	end
    end
    return ""
  end
  
  def dequeue(dir)
    if(@store != [] && @store != nil)
  		if(self.size>0)
  			usu = @store.first
  			@store.shift
  			if(usu.getHasAvatar)
  				usu = @store.first
  				dirAux = ""
  				if(usu!=nil)
  					usu.setHasAvatar(true)
  					if(dir == usu.dirIzq)
  						dirAux = usu.dirDer
  					elsif (dir == usu.dirDer)
  						dirAux = usu.dirIzq
  					else
  						dirAux = usu.dirNone
  					end
  					usu.setDirAvatar(dirAux)
  				end
  				return dirAux
  			end
    	end
    end
    return ""
  end
  
  def enqueue
  	if(@store == [] || @store == nil)
    	self.init
    end
    tam=self.size
    hasAvatar=false
    if(tam==0)
    	hasAvatar=true
    end
    usu = Usuario.new(tam,hasAvatar)
    @store << usu
    return tam
  end
  
  def size
    return @store.size
  end
  
  def displayAll
    if(@store != [] && @store != nil)
  		@store.each { |x| 
  			puts "id: " + x.getIdUsuario().to_s
    		puts "dir: " + x.getDirAvatar().to_s 
    		puts "hasAvatar: " + x.getHasAvatar().to_s
  		}
  	end
  end
  
  def whoHasAvatar
  	if(@store != [] && @store != nil)
  		@store.each { |x| 
  			if(x.getHasAvatar())
  				return x.getIdUsuario().to_s + "," + x.getDirAvatar().to_s 
  			end
  		}
  	end
  	return ""
  end
  
  def display
  	if(@store != [] && @store != nil)
  		usu = @store.last
  		puts usu.class.name
    	puts "id: " + usu.getIdUsuario().to_s
    	puts "dir: " + usu.getDirAvatar().to_s 
    	puts "hasAvatar: " + usu.getHasAvatar().to_s
    end
  end
end