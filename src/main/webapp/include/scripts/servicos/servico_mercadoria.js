AppInTruck.factory('ServicoMercadoria', ['$http', '$q', function($http, $q) {
	return {
		
		salvar: function(mercadoria, id) {
			return $http.post(ENDERECO_SERVIDOR +'/mercadoria/salvar/', mercadoria, id)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao salvar a mercadoria.');
						return $q.reject(errResponse);
					}
				);
		},
		
		remover: function(id) {
			return $http.delete(ENDERECO_SERVIDOR +'/mercadoria/remover/', id)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao remover a mercadoria.');
						return $q.reject(errResponse);
					}
				);
		},
		
		listarTodas: function() {
			return $http.get(ENDERECO_SERVIDOR +'mercadoria/listarTodas')
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao listar todas as mercadorias.');
						return $q.reject(errResponse);
					}
				);
		},
			
		buscarPorDescricao: function(descricao) {
			return $http.get(ENDERECO_SERVIDOR +'/mercadoria/buscarPorDescricao/', descricao)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao buscar por descricao a mercadoria.');
						return $q.reject(errResponse);
					}
				);
		},
		
		buscarContendoNaDescricao: function(descricao) {
			return $http.get(ENDERECO_SERVIDOR +'/mercadoria/buscarContendoNaDescricao/', descricao)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao buscar contendo na descricao a mercadoria.');
						return $q.reject(errResponse);
					}
				);
		},
		
		buscarPorId: function(id) {
			return $http.get(ENDERECO_SERVIDOR +'/mercadoria/buscarPorId/', id)
				.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Ocorreu um erro ao buscar por id a mercadoria.');
						return $q.reject(errResponse);
					}
				);
		}
		
	};
	
}]);
