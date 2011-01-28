package br.com.chapecosolucoes.trafegusweb.client.ws
{
    import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
    import br.com.chapecosolucoes.trafegusweb.client.components.wait.Wait;
    import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
    import br.com.chapecosolucoes.trafegusweb.client.model.UsuarioLogado;
    import br.com.chapecosolucoes.trafegusweb.client.utils.MyDateFormatter;
    import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;
    
    import mx.core.Application;
    import mx.core.FlexGlobals;
    import mx.formatters.DateFormatter;
    import mx.rpc.events.FaultEvent;
    import mx.rpc.events.ResultEvent;
    import mx.rpc.soap.mxml.Operation;
    import mx.rpc.soap.mxml.WebService;

    public class TrafegusWS
    {
        private static var instance:TrafegusWS = null;

        private var webservice:WebService = null;

        public function TrafegusWS(singletonForce:SingletonForcer)
        {
            if (singletonForce == null)
            {
                throw new Error("Utilize o metodo getIntance()");
            }
            this.webservice = new WebService();
            this.webservice.wsdl = UsuarioLogado.getInstance().wsdl;
            this.webservice.loadWSDL();
        }

        public static function getIntance():TrafegusWS
        {
            if (instance == null)
            {
                instance = new TrafegusWS(new SingletonForcer());
            }
            return instance;
        }
		
		public function removeEventListener(operationName:String, result:Function = null):void
		{
			var operation:Operation = Operation(this.webservice.getOperation(operationName));
			if (operation == null)
			{
				operation = new Operation(this.webservice, operationName);
				operation.showBusyCursor = true;
			}
			if (result != null)
			{
				operation.removeEventListener(ResultEvent.RESULT, result);
			}
		}

        private function createOperation(operationName:String, result:Function = null):Operation
        {
            var operation:Operation = Operation(this.webservice.getOperation(operationName));
            if (operation == null)
            {
                operation = new Operation(this.webservice, operationName);
                operation.showBusyCursor = true;
            }
            if (result != null)
            {
                operation.addEventListener(ResultEvent.RESULT, result);
            }
            operation.addEventListener(FaultEvent.FAULT, this.onFaultHandler);
            operation.addEventListener(ResultEvent.RESULT, this.onResultHander);
            Wait.getInstance().Show();
            return operation;
        }

        private function onFaultHandler(e:FaultEvent):void
        {
            Wait.getInstance().Close();
            MessageBox.erro(e.fault.message);
        }

        private function onResultHander(e:ResultEvent):void
        {
            Wait.getInstance().Close();
        }

        public function solicitaAcesso(solicitaAcessoHandler:Function, usuario:String, senha:String):void
        {
            var operation:Operation = createOperation("solicitaAcesso", solicitaAcessoHandler);
            operation.send(UsuarioLogado.getInstance().IdSessao, usuario, senha);
        }

        public function solicitaListaVeiculos(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaVeiculos", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function solicitaDadosGrid(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaDadosGrid", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function solicitaHistoricoPosicoes(handler:Function, params:PosicaoVeiculoVO, offset:int):void
        {
            var operation:Operation = createOperation("SolicitaHistoricoPosicoes", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, params.vehiclePlate, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina, false);
        }

        public function solicitaDadosMotorista(handler:Function, params:String):void
        {
            var operation:Operation = createOperation("solicitaDadosMotorista", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, params);
        }

        public function solicitaDadosVeiculo(handler:Function, params:String):void
        {
            var operation:Operation = createOperation("solicitaDadosVeiculo", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, params);
        }

        public function solicitaDadosGridEmViagem(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaDadosGridEmViagem", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function solicitaListaMotoristas(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaMotoristas", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function solicitaListaRotas(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaRotas", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa,MainModel.getInstance().smVO.codigoEmbarcador, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function solicitaListaEmbarcadores(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaEmbarcadores", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function solicitaListaTransportadores(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaTransportadores", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function solicitaDadosEmbarcador(handler:Function, param:String):void
        {
            var operation:Operation = createOperation("solicitaDadosEmbarcador", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, param);
        }

        public function solicitaDadosTransportador(handler:Function, param:String):void
        {
            var operation:Operation = createOperation("solicitaDadosTransportador", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, param);
        }

        public function solicitaListaLocais(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaLocais", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function solicitaListaTipoTransporte(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaTipoTransporte", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function solicitaDadosLocal(handler:Function, param:String):void
        {
            var operation:Operation = createOperation("solicitaDadosLocal", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, param);
        }

        public function solicitaListaCarretasDisponiveis(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaListaCarretasDisponiveis", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa);
        }

        public function solicitaListaPGR(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaPGR", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, MainModel.getInstance().smVO.codigoEmbarcador, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function solicitaDadosPGR(handler:Function, param:String):void
        {
            var operation:Operation = createOperation("solicitaDadosPGR", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, param);
        }

        public function solicitaListaViagemPai(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaViagemPai", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function solicitaListaTerminais(handler:Function,placaVeiculo:String):void
        {
            var operation:Operation = createOperation("solicitaListaTerminais", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, placaVeiculo);
        }

        public function solicitaTotalDadosGrid(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalDadosGrid", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa);
        }
		
		public function solicitaTotalDadosGridZoom(handler:Function):void
		{
			var operation:Operation = createOperation("solicitaTotalDadosGridZoom", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa);
		}

        public function solicitaTotalListaLocais(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaLocais", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaEmbarcadores(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaEmbarcadores", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaMotoristas(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaMotoristas", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaPGR(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaPGR", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa,MainModel.getInstance().smVO.codigoEmbarcador);
        }

        public function solicitaTotalListaRotas(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaRotas", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa,MainModel.getInstance().smVO.codigoEmbarcador);
        }

        public function solicitaTotalListaTipoTransporte(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaTipoTransporte", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao);
        }

        public function solicitaTotalListaTransportadores(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaTransportadores", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao);
        }

        public function solicitaTotalListaVeiculos(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaVeiculos", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaViagemPai(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaViagemPai", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalHistoricoPosicoes(handler:Function, params:PosicaoVeiculoVO):void
        {
            var operation:Operation = createOperation("solicitaTotalHistoricoPosicoes", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, params.vehiclePlate);
        }

        public function solicitaDadosTerminalDefeituoso(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaDadosTerminalDefeituoso", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().smVO.codTerminais);
        }

        public function solicitaTotalDadosGridEmViagem(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalDadosGridEmViagem", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa);
        }

        public function salvarPosicaoTelas(handler:Function):void
        {
            var operation:Operation = createOperation("salvarPosicaoTelas", handler);
            with (UsuarioLogado.getInstance().posicaoTelasVO)
            {
                operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codUsuario, gridVeiculosX, gridVeiculosY, gridVeiculosPercentWidth, gridVeiculosPercentHeight, mapaGoogleX, mapaGoogleY, mapaGooglePercentWidth, mapaGooglePercentHeight, gridDetalheX, gridDetalheY, gridDetalhePercentWidth, gridDetalhePercentHeight);
            }
        }

        public function solicitaClassesReferencias(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaClassesReferencias", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa);
        }

        public function solicitaRefencias(handler:Function, codClasseReferencia:String):void
        {
            var operation:Operation = createOperation("solicitaRefencias", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, codClasseReferencia);
        }
        public function solicitaRefenciasZoom(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaRefenciasZoom", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, offset, MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function lerPosicaoTelas(handler:Function):void
        {
            var operation:Operation = createOperation("lerPosicaoTelas", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codUsuario);
        }

        public function logout(handler:Function):void
        {
            var operation:Operation = createOperation("logout", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao);
        }

        public function solicitaDescricaoTipoTransporte(handler:Function, codTipoTransporte:String):void
        {
            var operation:Operation = createOperation("solicitaDescricaoTipoTransporte", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, codTipoTransporte);
        }

        public function solicitaDescricaoViagemPai(handler:Function, codViagemPai:String):void
        {
            var operation:Operation = createOperation("solicitaDescricaoViagemPai", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, codViagemPai);
        }

        public function solicitaDescricaoTransportador(handler:Function, codTransportador:String):void
        {
            var operation:Operation = createOperation("solicitaDescricaoTransportador", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, codTransportador);
        }

        public function solicitaDescricaoEmbarcador(handler:Function, codEmbarcador:String):void
        {
            var operation:Operation = createOperation("solicitaDescricaoEmbarcador", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, codEmbarcador);
        }

        public function solicitaDescricaoVeiculo(handler:Function, codVeiculo:String):void
        {
            var operation:Operation = createOperation("solicitaDescricaoVeiculo", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, codVeiculo);
        }

        public function solicitaDescricaoMotorista(handler:Function, codMotorista:String):void
        {
            var operation:Operation = createOperation("solicitaDescricaoMotorista", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa, codMotorista);
        }

        public function solicitaDescricaoPGR(handler:Function, codPGR:String):void
        {
            var operation:Operation = createOperation("solicitaDescricaoPGR", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, codPGR);
        }

        public function solicitaDescricaoRota(handler:Function, codRota:String):void
        {
            var operation:Operation = createOperation("solicitaDescricaoRota", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codEmpresa,MainModel.getInstance().smVO.codigoEmbarcador, codRota);
        }

        public function solicitaDescricaoLocalOrigem(handler:Function, codLocal:String):void
        {
            var operation:Operation = createOperation("solicitaDescricaoLocalOrigem", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, codLocal);
        }

        public function solicitaDescricaoLocalDestino(handler:Function, codLocal:String):void
        {
            var operation:Operation = createOperation("solicitaDescricaoLocalDestino", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, codLocal);
        }

        public function gravaTamanhoPosicaoColuna(handler:Function, tela:String, grid:String, coluna:String, tamanho:int, posicao:int, visible:String, titulo:String):void
        {
            var operation:Operation = createOperation("gravaTamanhoPosicaoColuna", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codUsuario, tela, grid, coluna, tamanho, posicao, visible, titulo);

        }

        public function gravaVisibilidadeColuna(handler:Function, tela:String, grid:String, coluna:String, visible:String):void
        {
            var operation:Operation = createOperation("gravaVisibilidadeColuna", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codUsuario, tela, grid, coluna, visible);

        }


        public function solicitaSMVeiculo(handler:Function, placaVeiculo:String,offset:int):void
        {
            var operation:Operation = createOperation("solicitaSMVeiculo", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, placaVeiculo, offset, MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
        }

        public function leConfiguracaoGrid(handler:Function, tela:String, grid:String):void
        {
            var operation:Operation = createOperation("leConfiguracaoGrid", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao, MainModel.getInstance().codUsuario, tela, grid);
        }
		public function solicitaDadosGridZoom(handler:Function,offset:int):void
		{
			var operation:Operation = createOperation("solicitaDadosGridZoom", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
		}
		public function procuraDadosGrid(handler:Function,posVeiculoVO:PosicaoVeiculoVO):void
		{
			var operation:Operation = createOperation("procuraDadosGrid", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, posVeiculoVO.vehiclePlate,posVeiculoVO.gpsDescSis);
		}
		public function solicitaTotalRefencias(handler:Function):void
		{
			var operation:Operation = createOperation("solicitaTotalRefencias", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa);
		}
		public function procuraRefenciasZoom(handler:Function,referenciaVO:ReferenciaVO):void
		{
			var operation:Operation = createOperation("procuraRefenciasZoom", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa,referenciaVO.refeDescricao,referenciaVO.descricao);
		}
		public function solicitaListaTipoParada(handler:Function,offset:int):void
		{
			var operation:Operation = createOperation("solicitaListaTipoParada", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao,offset,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
		}
		public function solicitaTotalListaTipoParada(handler:Function):void
		{
			var operation:Operation = createOperation("solicitaTotalListaTipoParada", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao);
		}
		public function solicitaTotalSMVeiculo(handler:Function,placaVeiculo:String):void
		{
			var operation:Operation = createOperation("solicitaTotalSMVeiculo", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao,placaVeiculo);
		}
		public function salvarItensPorPagina(handler:Function):void
		{
			var operation:Operation = createOperation("salvarItensPorPagina", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa,MainModel.getInstance().codUsuario,MainModel.getInstance().itensPorPaginaVO.itensPorPagina);
		}
		public function lerItensPorPagina(handler:Function):void
		{
			var operation:Operation = createOperation("lerItensPorPagina", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa,MainModel.getInstance().codUsuario);
		}
		public function solicitaParadasSM(handler:Function,numeroViagem:String):void
		{
			var operation:Operation = createOperation("solicitaParadasSM", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao,numeroViagem);
		}
		public function solicitaDadosGridCarretas(handler:Function,placaVeiculo:String):void
		{
			var operation:Operation = createOperation("solicitaDadosGridCarretas", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao,placaVeiculo);
		}
		public function necessitaValidarPesquisaMotorista(handler:Function,codPGR:String):void
		{
			var operation:Operation = createOperation("necessitaValidarPesquisaMotorista", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao,codPGR);
		}
		public function validarPesquisaMotorista(handler:Function,codVeiculo:String,codMotorista:String):void
		{
			var operation:Operation = createOperation("validarPesquisaMotorista", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao,codVeiculo,codMotorista);
		}
		public function salvaViagViagem(handler:Function):void
		{
			var operation:Operation = createOperation("salvaViagViagem", handler);
			operation.send(
				UsuarioLogado.getInstance().IdSessao,
				MainModel.getInstance().smVO.numeroViagem,/*viag_codigo - auto-incremento da tabela, ou seja: nextval('s_viag_viagem');*/
				MainModel.getInstance().smVO.viagDataCadastro,/*viag_data_cadastro - preencher com current_timestamp;*/
				MainModel.getInstance().smVO.codigoTipoViagem,/*viag_ttra_codigo - código do tipo de transporte selecionado na interface de agendamento; */
				MainModel.getInstance().codEmpresa,/*viag_tran_pess_oras_codigo - código do transportador selecionado para realizar o agendamento da viagem, */
				MainModel.getInstance().smVO.codigoEmbarcador,/*viag_emba_pjur_pess_oras_codigo - código do embarcador selecionado para realizar o agendamento da viagem (pode ser null); */
				MainModel.getInstance().smVO.codigoPGR,/*viag_pgpg_codigo - código do PGR selecionado na tela de agendamento para a viagem;*/
				MainModel.getInstance().smVO.valor,/*viag_valor_carga - valor da carga informado na tela de agendamento (tem RNE envolvida neste item);*/
				MainModel.getInstance().smVO.viagPrevisaoInicio,/*viag_previsao_inicio - data de previsão de inicio configurada para está viagem;*/
				MainModel.getInstance().smVO.viagPrevisaoFim,/*viag_previsao_fim - data de previsão de fim configurada para está viagem;*/
				"NULL",/*viag_data_inicio - preencher null no momento do agendamento (SM), somente será preenchida no momento da efetivação da viagem no trafegus;*/
				"NULL",/*viag_data_fim - preencher null no momento do agendamento (SM);*/
				MainModel.getInstance().smVO.distancia,/*viag_distancia - preencher com o valor da distância da rota quando a rota for selecionada (RNE);*/
				"NULL",/*viag_hpmo_codigo - preencher com o código de pesquisa do motorista se a mesma foi realizada (RNE); */
				"NULL",//viag_tempo_term_fora_area_risco
				"NULL",//viag_tempo_term_em_area_risco
				"NULL",//viag_tempo_term_fim_viagem
				MainModel.getInstance().smVO.viagCodigoPai,/*viag_codigo_pai - no caso de o agendamento ser um agendamento de retorno, chamar a consulta de viagens e preencher com o código da viagem de Ida;*/
				"NULL",//viag_codigo_gr - preencher null;
				"'N'",//viag_importado - preencher 'N';
				"NULL",/*viag_tope_codigo - preencher com o tipo de operação selecionada na tela de agendamento;*/
				MainModel.getInstance().codUsuario,/*viag_usuario_adicionou - preencher com o código do usuário que está realizando o agendamento;*/
				"NULL"/*viag_usuario_alterou - preencher somente quando for edição de agendamento, com o código do usuário que está editando a SM;*/
			);
		}
		public function salvaVveiViagemVeiculo(handler:Function,vvei_codigo:String,vvei_precedencia:String,vvei_veic_oras_codigo:String,vvei_moto_pfis_pess_oras_codigo:String,vvei_evca_codigo:String,vvei_sequencia:String,vvei_usuario_adicionou:String,vvei_usuario_alterou:String):void
		{
			var operation:Operation = createOperation("salvaVveiViagemVeiculo", handler);
			operation.send(
				UsuarioLogado.getInstance().IdSessao,
				vvei_codigo,//vvei_codigo - auto-incremento da tabela, ou seja: nextval('s_vvei_viagem_veiculo');
				vvei_precedencia,//vvei_precedencia - (1 - veículo principal, 2 - veículo secundário (geralmente carreta), 3 - veículo terciário (geralmente carreta), 4 - veículo quartenário (geralmente carreta);
				"currval('s_viag_viagem')",//vvei_viag_codigo - preencher com o código da viagem (SM) que está sendo criada;
				vvei_veic_oras_codigo,//vvei_veic_oras_codigo - código do veículo selecionado;
				vvei_moto_pfis_pess_oras_codigo,//vvei_moto_pfis_pess_oras_codigo - código do motorista do veículo (preencher somente no veículo principal)
				vvei_evca_codigo,//vvei_evca_codigo - preencher com a informação do estatus do veículo de carga (quando for um veículo de carga);
				"NULL",//vvei_comb_codigo - preencher null;
				"NULL",//vvei_data_inicio_comboio - preencher null;
				"NULL",//vvei_data_fim_comboio - preencher null;
				"'S'",//vvei_ativo - preencher com 'S';
				vvei_sequencia,//vvei_sequencia - sequencia dos veículos na viagem (1,2,3,4,5,6...)
				MainModel.getInstance().smVO.viagDataCadastro,//vvei_data_cadastro - preencher com current_timestamp;
				"NULL",//vvei_codigo_gr - preencher com null;
				"'N'",//vvei_importado - preencher com 'N';
				vvei_usuario_adicionou,//vvei_usuario_adicionou - preencher com o código do usuário que está realizando o agendamento;
				vvei_usuario_alterou//vvei_usuario_alterou - preencher somente quando for edição de agendamento, com o código do usuário que está editando a SM;
			);
		}
		public function salvaVterViagemTerminal(handler:Function,vter_codigo:String,vter_term_codigo:String,vter_precedencia:String,vter_tempo_satelital:String,vter_tempo_gprs:String,vter_usuario_adicionou:String,vter_usuario_alterou:String,vter_data_cadastro:String):void
		{
			var operation:Operation = createOperation("salvaVterViagemTerminal", handler);
			operation.send
			(
				UsuarioLogado.getInstance().IdSessao,
				vter_codigo,//vter_codigo - auto-incremento da tabela, ou seja: nextval('s_vter_viagem_terminal');
				"currval('s_viag_viagem')",//vter_viag_codigo - preencher com o código da viagem;
				vter_term_codigo,//preencher com o código do terminal;
				vter_precedencia,//preencher com a precedencia do terminal para a viagem (1 - primário; 2 secundário; 3 - outros);
				vter_tempo_satelital,//preencher com o tempo de posicionamento Satelital padrão (buscar na tabela de vtec_versao_tecnologia conforme o terminal);
				vter_tempo_gprs, //preencher com o tempo de posicionamento GPRS padrão (buscar na tabela de vtec_versao_tecnologia conforme o terminal);
				MainModel.getInstance().codUsuario, //vter_usua_pfis_pess_oras_codigo - preencher com o código do usuário que está realizando o agendamento;
				vter_data_cadastro,//vter_data_cadastro - preencher com current_timestamp;
				"NULL", //vter_codigo_gr - preencher com null;
				"'N'", //vter_importado - preencher com 'N';
				"'S'", //vter_ativo - preencher com 'S';
				vter_usuario_adicionou,//vter_usuario_adicionou - preencher com o código do usuário que está realizando o agendamento;
				vter_usuario_alterou //vter_usuario_alterou - preencher somente quando for edição de agendamento, com o código do usuário que está editando a SM;
			);
		}
		public function salvaVrotViagemRota(handler:Function):void
		{
			var operation:Operation = createOperation("salvaVrotViagemRota", handler);
			operation.send
			(
				UsuarioLogado.getInstance().IdSessao,
				MainModel.getInstance().smVO.rota.vrotCodigo,//vrot_codigo - auto-incremento da tabela, ou seja: nextval('s_vrot_viagem_rota');
				"currval('s_viag_viagem')",//vrot_viag_codigo - preencher com o código da viagem;
				MainModel.getInstance().smVO.rota.codigo,//vrot_rota_codigo - preencher com o código da rota selecionada / ou criada via site;
				MainModel.getInstance().smVO.rota.vrotDataCadastro,//vrot_data_cadastro - preencher com current_timestamp;
				"NULL",//vrot_codigo_gr - preencher com null;
				"'N'",//vrot_importado - preencher com 'N';
				"'S'",//vrot_ativo - preencher com 'S';
				MainModel.getInstance().smVO.rota.vrotUsuarioAdicionou, //vrot_usuario_adicionou - preencher com o código do usuário que está realizando o agendamento;
				MainModel.getInstance().smVO.rota.vrotUsuarioAlterou //vrot_usuario_alterou - preencher somente quando for edição de agendamento, com o código do usuário que está editando a SM;
			);
		}
		public function salvaVlocViagemLocal(handler:Function,vloc_codigo:String,vloc_sequencia:String,vloc_refe_codigo:String,vloc_tpar_codigo:String,vloc_raio:String,vloc_descricao:String,vloc_usuario_adicionou:String,vloc_usuario_alterou:String,vloc_data_cadastro:String):void
		{
			var operation:Operation = createOperation("salvaVlocViagemLocal", handler);
			operation.send
			(
				UsuarioLogado.getInstance().IdSessao,
				vloc_codigo,//vloc_codigo - auto-incremento da tabela, ou seja: nextval('s_vloc_viagem_local');
				vloc_sequencia,//vloc_sequencia - código de sequencia de passagem pelos locais no momento da viagem (1,2,3,4,5,6...);
				"currval('s_viag_viagem')",//vloc_viag_codigo - preencher com o codigo da viagem;
				vloc_refe_codigo,//vloc_refe_codigo - preencher com o código da referencia que representa este local;
				vloc_tpar_codigo,//vloc_tpar_codigo - preencher com o tipo de parada selecionado pelo usuário na interface;
				vloc_raio,//vloc_raio - preencher com o raio do local selecionado - tabela de referencias por transportador / embarcador;
				vloc_data_cadastro,//vloc_data_cadastro - preencher com current_timestamp;
				"NULL",//vloc_codigo_gr - preencher com null;
				"'N'",//vloc_importado - preencher com 'N';
				vloc_descricao,//vloc_descricao - preencher com a descrição do local selecionado;
				vloc_usuario_adicionou,//vloc_usuario_adicionou - preencher com o código do usuário que está realizando o agendamento;
				vloc_usuario_alterou//vloc_usuario_alterou - preencher somente quando for edição de agendamento, com o código do usuário que está editando a SM;
			);
		}
		public function salvaVlevViagemLocalEvento(handler:Function,vlev_codigo:String,vlev_vloc_codigo:String,vlev_sequencia:String,vlev_tlev_codigo:String,vlev_data_previsao:String,vlev_data:String,vlev_cpat_codigo:String,vlev_data_cadastro:String,vlev_usuario_adicionou:String,vlev_usuario_alterou:String):void
		{
			var operation:Operation = createOperation("salvaVlevViagemLocalEvento", handler);
			operation.send
			(
				UsuarioLogado.getInstance().IdSessao,
				vlev_codigo,//vlev_codigo - auto-incremento da tabela, ou seja: nextval('s_vlev_viagem_local_evento'); 
				vlev_vloc_codigo,//vlev_vloc_codigo - código do local da viagem;
				vlev_sequencia,//vlev_sequencia - sequencia de acontecimentos dos eventos (1,2,3,4,5,6...);
				vlev_tlev_codigo,//vlev_tlev_codigo - tipo de evento selecionado  pelo usuário;
				vlev_data_previsao, //vlev_data_previsao - data de previsão para o acontecimento do evento preenchido pelo usuário;
				vlev_data,//vlev_data - data de efetivação do evento - preencher null;
				vlev_cpat_codigo,//vlev_cpat_codigo - nome da celula de pátio selecionada pelo usuário (local do pátio aonde o evento ocorre);
				vlev_data_cadastro,//vlev_data_cadastro - preencher com current_timestamp; 
				"NULL",//vlev_codigo_gr - preencher com null;
				"'N'",//vlev_importado - preencher com 'N';
				vlev_usuario_adicionou,//vlev_usuario_adicionou - preencher com o código do usuário que está realizando o agendamento;
				vlev_usuario_alterou//vlev_usuario_alterou - preencher somente quando for edição de agendamento, com o código do usuário que está editando a SM;
			);
		}
    }
}

class SingletonForcer
{
}