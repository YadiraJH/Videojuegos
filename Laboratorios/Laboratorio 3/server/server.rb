require 'sinatra'
require './Queue'
require 'json'

set :bind, '192.168.1.74'
queue = Queue.new()

get '/' do
  "Bievenido al Videojuegos: Onde Esta Mi Leoncito"
end

get '/hello' do
  return "Bievenido al Videojuegos: Onde Esta Mi Leoncito"
end

get '/registrarse' do #llamar metodo al empezar videojuego para iniciar sesion
	tam=queue.enqueue
	queue.display
	return tam.to_s
end

get '/whoHasAvatar' do #devuelve que frame tendra el avatar, todos los clientes deben preguntarle
	return queue.whoHasAvatar
end

get '/saliendoStage' do #metodo para desbloquear el avatar cuando sale del escenario para que otro frame lo tenga
	content_type :json
	direccion = params["direccion"].to_s
	dir=queue.dequeueAndQueue(direccion)
	queue.displayAll
	return dir
end

get '/byeFrame' do #metodo para desbloquear el avatar cuando el frame se cierra
	content_type :json
	direccion = params["direccion"].to_s
	dir=queue.dequeue(direccion)
	queue.displayAll
	return dir
end

get '/consultapila' do
	queue.displayAll
	return ""
end
