AppInTruck.controller('ControleTrajeto', ['$scope', 'ServicoTrajeto', function($scope, ServicoTrajeto) {

	var self = this;
    self.trajeto = { id: 0, veiculo_id: 0, mercadorias: [], dataInclusao: '', tempoPrevisto: '', tempoReal: '', status: 0 };
    self.trajetos = [];
              
	self.salvar = function(trajeto, id) {
		ServicoTrajeto.salvar(trajeto, id)
			.then(
				self.listarTodos, 
				function(errResponse) {
					console.error('Erro salvando a trajeto.');
				}	
			);
	},
	
	self.remover = function(placa) {
		ServicoTrajeto.remover(placa)
			.then(
				self.listarTodos, 
				function(errResponse) {
					console.error('Erro removendo a trajeto.');
				}	
			);
	},
	
    self.listarTodos = function() {
		ServicoTrajeto.listarTodos()
    		.then(
    			function(d) {
    				self.trajetos = d;
    			},
    			function(errResponse) {
    				console.error('Erro atualizando a lista das trajetos.');
    			}
    		);
    };
   
	self.buscarPorData = function(data) {
		ServicoTrajeto.buscarPorData(data)
			.then(
				function(d) {
					self.trajeto = d;
				}, 
				function(errResponse) {
					console.error('Ocorreu um erro ao buscar por descricao a trajeto.');
					return $q.reject(errResponse);
				}
			);
	},
	
	self.buscarPorIntervaloDeData = function(dataInicial, dataFinal) {
		ServicoTrajeto.buscarPorIntervaloDeData(dataInicial, dataFinal)
			.then(
				function(d) {
					self.trajeto = d;
				}, 
				function(errResponse) {
					console.error('Ocorreu um erro ao buscar contendo na descricao a trajeto.');
					return $q.reject(errResponse);
				}
			);
	},
	
	self.reset = function() {
		self.trajeto = { id: 0, veiculo_id: 0, mercadorias: [], dataInclusao: '', tempoPrevisto: '', tempoReal: '', status: 0 };
		$scope.formTrajeto.$setPristine(); //reset Form
	};

}]);
