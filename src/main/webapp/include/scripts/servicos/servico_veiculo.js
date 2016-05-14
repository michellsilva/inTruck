AppInTruck.factory('ServicoVeiculo', ['$http', '$q', function($http, $q) {
	return {
		
		salvar: function(veiculo, id) {
			return $http.post(ENDERECO_SERVIDOR +'/veiculo/salvar/', veiculo, id)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao salvar o veiculo.');
						return $q.reject(errResponse);
					}
				);
		},
		
		remover: function(placa) {
			return $http.delete(ENDERECO_SERVIDOR +'/veiculo/remover/', placa)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao remover o veiculo.');
						return $q.reject(errResponse);
					}
				);
		},
		
		listarTodos: function() {
			return $http.get(ENDERECO_SERVIDOR +'veiculo/listarTodos')
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao listar todos os veiculos.');
						return $q.reject(errResponse);
					}
				);
		},
			
		buscarPorPlaca: function(placa) {
			return $http.get(ENDERECO_SERVIDOR +'/veiculo/buscarPorPlaca/', placa)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao buscar por placa o veiculo.');
						return $q.reject(errResponse);
					}
				);
		},
		
		buscarPelaMarca: function(placa) {
			return $http.get(ENDERECO_SERVIDOR +'/veiculo/buscarPelaMarca/', placa)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao buscar pela placa o veiculo.');
						return $q.reject(errResponse);
					}
				);
		}
		
	};
	
}]);
