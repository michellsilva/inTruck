AppInTruck.controller('ControleMercadoria', ['$scope', 'ServicoMercadoria', function($scope, ServicoMercadoria) {

	var self = this;
    self.mercadoria = { id: 0, descricao: '', peso: 0, fragilidade: 0, prioridade: 0, cep: '', pais: '', estado: '', municipio: '', logradouro: '', numero: '', nomeReceb: '', telefoneReceb: '', ativo: false, trajeto_id: 0 };
    self.mercadorias = [];
              
	self.salvar = function(mercadoria, id) {
		ServicoMercadoria.salvar(mercadoria, id)
			.then(
				self.listarTodas, 
				function(errResponse) {
					console.error('Erro salvando a mercadoria.');
				}	
			);
	},
	
	self.remover = function(id) {
		ServicoMercadoria.remover(id)
			.then(
				self.listarTodas, 
				function(errResponse) {
					console.error('Erro removendo a mercadoria.');
				}	
			);
	},
	
    self.listarTodas = function() {
		ServicoMercadoria.listarTodas()
    		.then(
    			function(d) {
    				self.mercadorias = d;
    			},
    			function(errResponse) {
    				console.error('Erro atualizando a lista das mercadorias.');
    			}
    		);
    };
   
	self.buscarPorDescricao = function(descricao) {
		ServicoMercadoria.buscarPorDescricao(descricao)
			.then(
				function(d) {
					self.mercadoria = d;
				}, 
				function(errResponse) {
					console.error('Ocorreu um erro ao buscar por descricao a mercadoria.');
					return $q.reject(errResponse);
				}
			);
	},
	
	self.buscarContendoNaDescricao = function(descricao) {
		ServicoMercadoria.buscarContendoNaDescricao(descricao)
			.then(
				function(d) {
					self.mercadoria = d;
				}, 
				function(errResponse) {
					console.error('Ocorreu um erro ao buscar contendo na descricao a mercadoria.');
					return $q.reject(errResponse);
				}
			);
	},
	
	self.buscarPorId = function(id) {
		ServicoMercadoria.buscarPorId(id)
			.then(
				function(d) {
					self.mercadoria = d;
				}, 
				function(errResponse) {
					console.error('Ocorreu um erro ao buscar por id a mercadoria.');
					return $q.reject(errResponse);
				}
			);
	},
	
	self.reset = function() {
		self.mercadoria = { id: 0, descricao: '', peso: 0, fragilidade: 0, prioridade: 0, cep: '', pais: '', estado: '', municipio: '', logradouro: '', numero: '', nomeReceb: '', telefoneReceb: '', ativo: false, trajeto_id: 0 };
		$scope.formMercadoria.$setPristine(); //reset Form
	};

}]);
