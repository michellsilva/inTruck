AppInTruck.factory('ServicoTrajeto', ['$http', '$q', function($http, $q) {
	return {
		
		salvar: function(trajeto, id) {
			return $http.post(ENDERECO_SERVIDOR +'/trajeto/salvar/', trajeto, id)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao salvar o trajeto.');
						return $q.reject(errResponse);
					}
				);
		},
		
		remover: function(placa) {
			return $http.delete(ENDERECO_SERVIDOR +'/trajeto/remover/', placa)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao remover o trajeto.');
						return $q.reject(errResponse);
					}
				);
		},
		
		listarTodos: function() {
			return $http.get(ENDERECO_SERVIDOR +'trajeto/listarTodos')
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao listar todos os trajetos.');
						return $q.reject(errResponse);
					}
				);
		},
			
		buscarPorData: function(data) {
			return $http.get(ENDERECO_SERVIDOR +'/trajeto/buscarPorData/', data)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao buscar por data o trajeto.');
						return $q.reject(errResponse);
					}
				);
		},
		
		buscarPorIntervaloDeData: function(dataInicial, dataFinal) {
			return $http.get(ENDERECO_SERVIDOR +'/trajeto/buscarPorIntervaloDeData/', dataInicial, dataFinal)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao buscar por intervalo de data o trajeto.');
						return $q.reject(errResponse);
					}
				);
		}
		
	};
	
}]);
