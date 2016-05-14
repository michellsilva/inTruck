AppInTruck.controller('ControleVeiculo', ['$scope', 'ServicoVeiculo', function($scope, ServicoVeiculo) {

	var self = this;
    self.veiculo = { id: 0, veiculo_id: 0, mercadorias: [], dataInclusao: '', tempoPrevisto: '', tempoReal: '', status: 0 };
    self.veiculos = [];
              
	self.salvar = function(veiculo, id) {
		ServicoVeiculo.salvar(veiculo, id)
			.then(
				self.listarTodos, 
				function(errResponse) {
					console.error('Erro salvando a veiculo.');
				}	
			);
	},
	
	self.remover = function(id) {
		ServicoVeiculo.remover(id)
			.then(
				self.listarTodos, 
				function(errResponse) {
					console.error('Erro removendo a veiculo.');
				}	
			);
	},
	
    self.listarTodos = function() {
		ServicoVeiculo.listarTodos()
    		.then(
    			function(d) {
    				self.veiculos = d;
    			},
    			function(errResponse) {
    				console.error('Erro atualizando a lista das veiculos.');
    			}
    		);
    };
   
	self.buscarPorPlaca = function(placa) {
		ServicoVeiculo.buscarPorPlaca(placa)
			.then(
				function(d) {
					self.veiculo = d;
				}, 
				function(errResponse) {
					console.error('Ocorreu um erro ao buscar por descricao a veiculo.');
					return $q.reject(errResponse);
				}
			);
	},
	
	self.buscarPelaMarca = function(placa) {
		ServicoVeiculo.buscarPelaMarca(placa)
			.then(
				function(d) {
					self.veiculo = d;
				}, 
				function(errResponse) {
					console.error('Ocorreu um erro ao buscar contendo na descricao a veiculo.');
					return $q.reject(errResponse);
				}
			);
	},
	
	self.reset = function() {
		self.veiculo = { id: 0, veiculo_id: 0, mercadorias: [], dataInclusao: '', tempoPrevisto: '', tempoReal: '', status: 0 };
		$scope.formVeiculo.$setPristine(); //reset Form
	};

}]);
