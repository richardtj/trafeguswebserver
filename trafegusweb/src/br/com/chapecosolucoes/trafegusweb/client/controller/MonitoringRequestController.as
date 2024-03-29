package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.CarretasZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.EmbarcadoresZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.LocaisZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.MotoristaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PGRZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.RotaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.TipoTransporteZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.TransportadoresZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.VeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ViagemPaiZoom;
	import br.com.chapecosolucoes.trafegusweb.client.enum.LocaisEnum;
	import br.com.chapecosolucoes.trafegusweb.client.events.AddParadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.EmbarcadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PGRSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedDriverEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedLocalEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedRouteEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedVehicleEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TipoTransporteSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TransportadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ViagemPaiSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ZoomCodDetailEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.AddCarretasView;
	import br.com.chapecosolucoes.trafegusweb.client.view.AddParadasView;
	import br.com.chapecosolucoes.trafegusweb.client.view.MonitoringRequestWiew;
	import br.com.chapecosolucoes.trafegusweb.client.events.CarretaSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ParadaVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PesquisaMotoristaVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.RouteVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TerminalDefeituosoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TerminalVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoViagemVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.display.DisplayObject;
	
	import mx.controls.Alert;
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import org.flexunit.runner.Result;

	public class MonitoringRequestController
	{
		public function MonitoringRequestController()
		{
		}
		public var view:MonitoringRequestWiew;
		public function veiculoZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var veiculoZoom:VeiculoZoom = new VeiculoZoom();
				veiculoZoom.addEventListener(SelectedVehicleEvent.SELECTED_VEHICLE_EVENT,selectedVehicleEventHandler);
				MyPopUpManager.addPopUp(veiculoZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(veiculoZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoVeiculo(solicitaDescricaoVeiculoResultHandler,event.cod);
			}
		}
		public function solicitaDescricaoVeiculoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.veiculoPrincipal= new VeiculoVO();
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.veiculoPrincipal.setVeiculoVO(obj);
				MainModel.getInstance().smVO.veiculoPrincipal.precedencia = "1";
				MainModel.getInstance().smVO.terminaisArray.removeAll();
				TrafegusWS.getIntance().solicitaListaTerminais(solicitaListaTerminaisResultHandler,MainModel.getInstance().smVO.veiculoPrincipal.vehiclePlate);
			}
			TrafegusWS.getIntance().removeEventListener("solicitaDescricaoVeiculo",this.solicitaDescricaoVeiculoResultHandler);
		}
		public function selectedVehicleEventHandler(event:SelectedVehicleEvent):void
		{
			MainModel.getInstance().smVO.veiculoPrincipal = event.veiculo;
			MainModel.getInstance().smVO.veiculoPrincipal.precedencia = "1";
			MainModel.getInstance().smVO.terminaisArray.removeAll();
			this.view.dadosAdicionaisView.atualizaTerminais();
		}
		public function addCarretas():void
		{
			var carretasZoom:CarretasZoom = new CarretasZoom();
			carretasZoom.addEventListener(CarretaSelecionadaEvent.CARRETA_SELECIONADA_EVENT,carretaSelecionadaEventHandler);
			MyPopUpManager.addPopUp(carretasZoom,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(carretasZoom);
		}
		private function carretaSelecionadaEventHandler(event:CarretaSelecionadaEvent):void
		{
			this.solicitaListaTerminais(event.carreta.vehiclePlate);
			MainModel.getInstance().carretasDisponiveisArray.removeItemAt(MainModel.getInstance().carretasDisponiveisArray.getItemIndex(event.carreta));
			MainModel.getInstance().smVO.carretas.addItem(event.carreta);
		}
		private function removeTerminais(placa:String):void
		{
			for (var i:int=0;i < MainModel.getInstance().smVO.terminaisArray.length;i++)
			{
				var terminal:TerminalVO = TerminalVO(MainModel.getInstance().smVO.terminaisArray.getItemAt(i));
				if(terminal.veicPlaca == placa)
				{
					MessageBox.informacao("removendo terminal"+terminal.codigo);
					MainModel.getInstance().smVO.terminaisArray.removeItemAt(i);
					i--;
				}
			}
		}
		public function removeCarretas():void
		{
			if(this.view.grid1.selectedItem != null)
			{
				var carreta:VeiculoVO = VeiculoVO(MainModel.getInstance().smVO.carretas.removeItemAt(MainModel.getInstance().smVO.carretas.getItemIndex(this.view.grid1.selectedItem)));
				this.removeTerminais(carreta.vehiclePlate);
				MainModel.getInstance().carretasDisponiveisArray.addItem(carreta);
			}
			else
			{
				MessageBox.informacao("Nenhuma carreta selecionada.");
			}
		}
		public function addParadas():void
		{
			var addParadasView:AddParadasView = new AddParadasView();
			MyPopUpManager.addPopUp(addParadasView,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(addParadasView);
		}
		public function motoristaZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var motoristaZoom:MotoristaZoom = new MotoristaZoom();
				motoristaZoom.addEventListener(SelectedDriverEvent.SELECTED_DRIVER_EVENT,selectedDriverEventHandler);
				MyPopUpManager.addPopUp(motoristaZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(motoristaZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoMotorista(solicitaDescricaoMotoristaResultHandler,event.cod);
			}
		}
		public function solicitaDescricaoMotoristaResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.nomeMotorista = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.nomeMotorista = obj.nome_motorista.toString();
			}
		}
		private function selectedDriverEventHandler(event:SelectedDriverEvent):void
		{
			MainModel.getInstance().smVO.codigoMotorista = event.motorista.codigo;
			MainModel.getInstance().smVO.nomeMotorista = event.motorista.motoristaPrincipal;
		}
		private function validarPesquisaMotoristaResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			var pesquisaMotoristaVO:PesquisaMotoristaVO = new PesquisaMotoristaVO();
			for each (var obj:Object in resultArray)
			{
				pesquisaMotoristaVO.setPesquisaMotoristaVO(obj);
			}
			MainModel.getInstance().pesquisaMotoristaVO = pesquisaMotoristaVO;
			if(MainModel.getInstance().pesquisaMotoristaVO.codigo != "")
			{
				MessageBox.informacao("O motorista " + MainModel.getInstance().smVO.nomeMotorista + " não pode dirigir o veiculo "+MainModel.getInstance().smVO.veiculoPrincipal.vehiclePlate + " no PGR " + MainModel.getInstance().smVO.descricaoPGR);
				MainModel.getInstance().salvarSMEnabled = false;
			}
			else
			{
				MainModel.getInstance().salvarSMEnabled = true;
			}
		}
		public function rotaZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var rotaZoom:RotaZoom = new RotaZoom();
				rotaZoom.addEventListener(SelectedRouteEvent.SELECTED_ROUTE_EVENT,selectedRouteEventHandler);
				MyPopUpManager.addPopUp(rotaZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(rotaZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoRota(solicitaDescricaoRotaResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoRotaResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.rota = new RouteVO();
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.rota.setRouteVO(obj);
			}
		}
		private function selectedRouteEventHandler(event:SelectedRouteEvent):void
		{
			MainModel.getInstance().smVO.rota = event.route;
		}
		public function embarcadoresZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var embarcadoresZoom:EmbarcadoresZoom = new EmbarcadoresZoom();
				embarcadoresZoom.addEventListener(EmbarcadorSelecionadoEvent.EMBARCADOR_SELECIONADO_EVENT,embarcadorSelecionadoEventHandler);
				MyPopUpManager.addPopUp(embarcadoresZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(embarcadoresZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoEmbarcador(solicitaDescricaoEmbarcadorResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoEmbarcadorResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.nomeEmbarcador = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.nomeEmbarcador = obj.pess_nome.toString();
			}
		}
		private function embarcadorSelecionadoEventHandler(event:EmbarcadorSelecionadoEvent):void
		{
			MainModel.getInstance().smVO.codigoEmbarcador = event.embarcador.codigo;
			MainModel.getInstance().smVO.nomeEmbarcador = event.embarcador.nome;
		}
		public function locaisZoomDispatcher(enum:LocaisEnum,event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var locaisZoom:LocaisZoom = new LocaisZoom();
				if(enum == LocaisEnum.ORIGEM)
				{
					locaisZoom.addEventListener(SelectedLocalEvent.SELECTED_LOCAL_EVENT,origemSelecionadaEventHandler);
				}
				else if(enum == LocaisEnum.DESTINO)
				{
					locaisZoom.addEventListener(SelectedLocalEvent.SELECTED_LOCAL_EVENT,destinoSelecionadoEventHandler);
				}
				MyPopUpManager.addPopUp(locaisZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(locaisZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				if(enum == LocaisEnum.ORIGEM)
				{
					TrafegusWS.getIntance().solicitaDescricaoLocalOrigem(solicitaDescricaoLocalOrigemResultHandler,event.cod);
				}
				else if(enum == LocaisEnum.DESTINO)
				{
					TrafegusWS.getIntance().solicitaDescricaoLocalDestino(solicitaDescricaoLocalDestinoResultHandler,event.cod);
				}
			}
		}
		private function solicitaDescricaoLocalOrigemResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.rota.localOrigem = new LocalVO();
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.rota.localOrigem.setLocalVO(obj);
			}
		}
		private function solicitaDescricaoLocalDestinoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.rota.localDestino = new LocalVO();
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.rota.localDestino.setLocalVO(obj);
			}
		}
		private function origemSelecionadaEventHandler(event:SelectedLocalEvent):void
		{
			MainModel.getInstance().smVO.rota.localOrigem = event.local;
		}
		private function destinoSelecionadoEventHandler(event:SelectedLocalEvent):void
		{
			MainModel.getInstance().smVO.rota.localDestino = event.local;
		}
		public function transportadorZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var transportadoresZoom:TransportadoresZoom = new TransportadoresZoom();
				transportadoresZoom.addEventListener(TransportadorSelecionadoEvent.TRANSPORTADOR_SELECIONADO_EVENT,transportadorSelecionadoEventHandler);
				MyPopUpManager.addPopUp(transportadoresZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(transportadoresZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoTransportador(solicitaDescricaoTransportadorResultHandler,event.cod);
			}
		}
		public function solicitaDescricaoTransportadorResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.nomeTransportador = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.nomeTransportador = obj.pess_nome.toString();
			}
		}
		private function transportadorSelecionadoEventHandler(event:TransportadorSelecionadoEvent):void
		{
			MainModel.getInstance().smVO.codigoTransportador = event.transportador.codigo;
			MainModel.getInstance().smVO.nomeTransportador = event.transportador.nome;
		}
		public function tipoTransporteZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var tipoTransporteZoom:TipoTransporteZoom = new TipoTransporteZoom();
				tipoTransporteZoom.addEventListener(TipoTransporteSelecionadoEvent.TIPO_TRANSPORTE_SELECIONADO_EVENT,tipoTransporteSelecionadoEventHandler);
				MyPopUpManager.addPopUp(tipoTransporteZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(tipoTransporteZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoTipoTransporte(solicitaDescricaoTipoTransporteEventHandler,event.cod);
			}
		}
		private function solicitaDescricaoTipoTransporteEventHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.descricaoTipoViagem = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.descricaoTipoViagem = obj.ttra_descricao.toString();
			}
		}
		private function tipoTransporteSelecionadoEventHandler(event:TipoTransporteSelecionadoEvent):void
		{
			MainModel.getInstance().smVO.codigoTipoViagem = event.tipoTransporte.codigo;
			MainModel.getInstance().smVO.descricaoTipoViagem = event.tipoTransporte.descricao;
		}
		
		public function planoGRZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var pgrZoom:PGRZoom = new PGRZoom();
				pgrZoom.addEventListener(PGRSelecionadoEvent.PGR_SELECIONADO_EVENT,pgrSelecionadoEventHandler);
				MyPopUpManager.addPopUp(pgrZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(pgrZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoPGR(solicitaDescricaoPGRResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoPGRResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.descricaoPGR = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.descricaoPGR = obj.pgpg_descricao.toString();
				TrafegusWS.getIntance().necessitaValidarPesquisaMotorista(necessitaValidarPesquisaMotoristaResultHandler,MainModel.getInstance().smVO.codigoPGR);
			}
		}
		private function pgrSelecionadoEventHandler(event:PGRSelecionadoEvent):void
		{
			MainModel.getInstance().smVO.codigoPGR = event.pgr.codigo;
			MainModel.getInstance().smVO.descricaoPGR = event.pgr.descricao;
			
			TrafegusWS.getIntance().necessitaValidarPesquisaMotorista(necessitaValidarPesquisaMotoristaResultHandler,event.pgr.codigo);
		}
		private function necessitaValidarPesquisaMotoristaResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().necessarioConsultaMotorista = "";
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().necessarioConsultaMotorista = obj.necessarioconsultamotorista.toString();
			}
			if(MainModel.getInstance().necessarioConsultaMotorista == "SIM")
			{
				TrafegusWS.getIntance().validarPesquisaMotorista(validarPesquisaMotoristaResultHandler,MainModel.getInstance().smVO.veiculoPrincipal.cod,MainModel.getInstance().smVO.codigoMotorista);
			}
			else
			{
				MainModel.getInstance().salvarSMEnabled = true;
			}
		}
		public function viagemPaiZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var viagemPaiZoom:ViagemPaiZoom = new ViagemPaiZoom();
				viagemPaiZoom.addEventListener(ViagemPaiSelecionadaEvent.VIAGEM_PAI_SELECIONADA_EVENT,viagemPaiSelecionadaResultHandler);
				MyPopUpManager.addPopUp(viagemPaiZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(viagemPaiZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoViagemPai(solicitaDescricaoViagemPaiResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoViagemPaiResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.previsaoInicioViagemPai = "";
				MainModel.getInstance().smVO.previsaoFimViagemPai = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.previsaoInicioViagemPai = obj.viag_previsao_inicio.toString();
				MainModel.getInstance().smVO.previsaoFimViagemPai = obj.viag_previsao_fim.toString();
			}
		}
		private function viagemPaiSelecionadaResultHandler(event:ViagemPaiSelecionadaEvent):void
		{
			MainModel.getInstance().smVO.codigoViagemPai = event.viagemPai.codigo;
			MainModel.getInstance().smVO.previsaoInicioViagemPai = event.viagemPai.previsaoInicio;
			MainModel.getInstance().smVO.previsaoFimViagemPai = event.viagemPai.previsaoFim;
		}
		public function closeHandler():void
		{
			MyPopUpManager.removePopUp(this.view);
		}
		public function salvarSM():void
		{
			TrafegusWS.getIntance().beginTransaction(beginTransactionResultHandler,beginTransactionFaultHandler);
		}
		public function atualizarSM():void
		{
			
		}
		private function beginTransactionResultHandler(event:ResultEvent):void
		{
			TrafegusWS.getIntance().removeEventListener("beginTransaction",this.beginTransactionResultHandler,this.beginTransactionFaultHandler);
			MainModel.getInstance().smVO.veiculoPrincipal.vveiMotoPfisPessOrasCodigo = MainModel.getInstance().smVO.codigoMotorista;
			TrafegusWS.getIntance().salvaViagViagem(salvaViagViagemResultHandler,salvaViagViagemFaultHandler);
			this.closeHandler();
		}
		private function beginTransactionFaultHandler(event:FaultEvent):void
		{
			MessageBox.informacao("Problemas ai iniciar transação "+event.fault.message);
		}
		private function salvaViagViagemFaultHandler(event:FaultEvent):void
		{
			MessageBox.informacao("Erro ao salvar ViagViagem " + event.fault.message);
			TrafegusWS.getIntance().rollBackTransaction(rollBackTransactionResultHandler);
		}
		private function rollBackTransactionResultHandler(event:ResultEvent):void
		{
			MessageBox.informacao("Não foi possivel salvar a solicitação de monitoramento.");
		}
		private function rollBackTransactionFaultHandler(event:FaultEvent):void
		{
			MessageBox.informacao("Problemas ao desfazer transação "+event.fault.message);
		}
		private function salvaViagViagemResultHandler(event:ResultEvent):void
		{
			TrafegusWS.getIntance().salvaVrotViagemRota(salvaVrotViagemRotaResultHandler,salvaVrotViagemRotaFaultHandler);
		}
		private function commitTransactionResultHandler(event:ResultEvent):void
		{
			TrafegusWS.getIntance().removeEventListener("commitTransaction",this.commitTransactionResultHandler,this.commitTransactionFaultHandler);
			MessageBox.informacao("Solicitação de monitoramento salva com sucesso.");
			//MainModel.getInstance().smVO.terminaisArray.removeAll();
			//MainModel.getInstance().smVO.terminaisDefeituososArray.removeAll();
		}
		private function commitTransactionFaultHandler(event:FaultEvent):void
		{
			MessageBox.informacao("Problemas ao comitar transação " + event.fault.message);
		}
		private function salvaVlocViagemLocalResultHandler(event:ResultEvent):void
		{
			TrafegusWS.getIntance().removeEventListener("salvaVlocViagemLocal",this.salvaVlocViagemLocalResultHandler,this.salvaVlocViagemLocalFaultHandler);
			MainModel.getInstance().paradasSalvas++;
			if(MainModel.getInstance().paradasSalvas == MainModel.getInstance().smVO.paradas.length)
			{
				TrafegusWS.getIntance().commitTransaction(commitTransactionResultHandler,commitTransactionFaultHandler);
			}
		}
		private function salvaVlocViagemLocalFaultHandler(event:FaultEvent):void
		{
			MessageBox.informacao("Erro ao salvar VlocViagemLocal "+event.fault.message);
			TrafegusWS.getIntance().rollBackTransaction(this.rollBackTransactionResultHandler);
		}
		private function salvaVlocViagemLocalOrigemResultHandler(event:ResultEvent):void
		{
			TrafegusWS.getIntance().removeEventListener("salvaVlocViagemLocal",this.salvaVlocViagemLocalOrigemResultHandler,this.salvaVlocViagemLocalOrigemFaultHandler);
			with(MainModel.getInstance().smVO.rota.localDestino)
			{
				TrafegusWS.getIntance().salvaVlocViagemLocal(salvaVlocViagemLocalDestinoResultHandler,salvaVlocViagemLocalDestinoFaultHandler,vlocCodigo,vlocSequencia,codigo,vlocTparCodigo,vlocRaio,vlocDescricao,vlocUsuarioAdicionou,vlocUsuarioAlterou,vlocDataCadastro);
			}
		}
		private function salvaVlocViagemLocalOrigemFaultHandler(event:FaultEvent):void
		{
			MessageBox.informacao("Erro ao salvar VlocViagemLocalOrigem "+event.fault.message);
			TrafegusWS.getIntance().rollBackTransaction(this.rollBackTransactionResultHandler);
		}
		private function salvaVlocViagemLocalDestinoResultHandler(event:ResultEvent):void
		{
			TrafegusWS.getIntance().removeEventListener("salvaVlocViagemLocal",this.salvaVlocViagemLocalDestinoResultHandler,this.salvaVlocViagemLocalDestinoFaultHandler);
			MainModel.getInstance().paradasSalvas = 0;
			if(MainModel.getInstance().smVO.paradas.length > 0)
			{
				for each(var paradaVO:ParadaVO in MainModel.getInstance().smVO.paradas)
				{
					TrafegusWS.getIntance().salvaVlocViagemLocal(salvaVlocViagemLocalResultHandler,salvaVlocViagemLocalFaultHandler,paradaVO.localVO.vlocCodigo,paradaVO.localVO.vlocSequencia,paradaVO.localVO.codigo,paradaVO.tipoParadaVO.codigo,paradaVO.localVO.vlocRaio,paradaVO.localVO.vlocDescricao,paradaVO.localVO.vlocUsuarioAdicionou,paradaVO.localVO.vlocUsuarioAlterou,paradaVO.localVO.vlocDataCadastro);
				}
			}
			else
			{
				TrafegusWS.getIntance().commitTransaction(commitTransactionResultHandler,commitTransactionFaultHandler);
			}
		}
		private function salvaVlocViagemLocalDestinoFaultHandler(event:FaultEvent):void
		{
			MessageBox.informacao("Erro ao salvar VlocViagemLocalDestino "+event.fault.message);
			TrafegusWS.getIntance().rollBackTransaction(this.rollBackTransactionResultHandler);
		}
		private function salvaVrotViagemRotaResultHandler(event:ResultEvent):void
		{
			with(MainModel.getInstance().smVO.veiculoPrincipal)
			{
				TrafegusWS.getIntance().salvaVveiViagemVeiculo(salvaVveiViagemVeiculoPrincipalResultHandler,salvaVveiViagemVeiculoPrincipalFaultHandler,vveiCodigo,precedencia,cod,vveiMotoPfisPessOrasCodigo,vveiEvcaCodigo,vveiSequencia,vveiUsuarioAdicionou,vveiUsuarioAlterou);
			}
		}
		private function salvaVrotViagemRotaFaultHandler(event:FaultEvent):void
		{
			MessageBox.informacao("Erro ao salvar VrotViagemRota "+event.fault.message);
			TrafegusWS.getIntance().rollBackTransaction(this.rollBackTransactionResultHandler);
		}
		private function salvaVterViagemTerminalResultHandler(event:ResultEvent):void
		{
			TrafegusWS.getIntance().removeEventListener("salvaVterViagemTerminal",this.salvaVterViagemTerminalResultHandler,this.salvaVterViagemTerminalFaultHandler);
			MainModel.getInstance().terminaisSalvos++;
			var terminaisSalvos:int = MainModel.getInstance().terminaisSalvos;
			var terminaisArrayLength:int = MainModel.getInstance().smVO.terminaisArray.length;
			if(MainModel.getInstance().terminaisSalvos == MainModel.getInstance().smVO.terminaisArray.length)
			{
				with(MainModel.getInstance().smVO.rota.localOrigem)
				{
					TrafegusWS.getIntance().salvaVlocViagemLocal(salvaVlocViagemLocalOrigemResultHandler,salvaVlocViagemLocalOrigemFaultHandler,vlocCodigo,vlocSequencia,codigo,vlocTparCodigo,vlocRaio,vlocDescricao,vlocUsuarioAdicionou,vlocUsuarioAlterou,vlocDataCadastro);
				}
			}
		}
		private function salvaVterViagemTerminalFaultHandler(event:FaultEvent):void
		{
			MessageBox.informacao("Erro ao salvar VterViagemTerminal " + event.fault.message);
			TrafegusWS.getIntance().rollBackTransaction(this.rollBackTransactionResultHandler);
		}
		private function salvaVveiViagemVeiculoResultHandler(event:ResultEvent):void
		{
			TrafegusWS.getIntance().removeEventListener("salvaVveiViagemVeiculo",this.salvaVveiViagemVeiculoResultHandler,this.salvaVveiViagemVeiculoFaultHandler);
			MainModel.getInstance().carretasSalvas++;
			if(MainModel.getInstance().carretasSalvas == MainModel.getInstance().smVO.carretas.length)
			{
				MainModel.getInstance().terminaisSalvos = 0;
				for each(var terminalVO:TerminalVO in MainModel.getInstance().smVO.terminaisArray)
				{
					with(terminalVO)
					{
						TrafegusWS.getIntance().salvaVterViagemTerminal(salvaVterViagemTerminalResultHandler,salvaVterViagemTerminalFaultHandler,vterCodigo,codigo,precedencia,tempoSatelital,tempoGPRS,vterUsuarioAdicionou,vterUsuarioAlterou,vterDataCadastro);
					}
				}
			}
		}
		private function salvaVveiViagemVeiculoFaultHandler(event:FaultEvent):void
		{
			MessageBox.informacao("Erro ao salvar VveiViagemVeiculoPrincipal "+event.fault.message);
			TrafegusWS.getIntance().rollBackTransaction(this.rollBackTransactionResultHandler);
		}
		private function salvaVveiViagemVeiculoPrincipalResultHandler(event:ResultEvent):void
		{
			TrafegusWS.getIntance().removeEventListener("salvaVveiViagemVeiculo",this.salvaVveiViagemVeiculoPrincipalResultHandler,this.salvaVveiViagemVeiculoPrincipalFaultHandler);
			MainModel.getInstance().carretasSalvas = 0;
			if(MainModel.getInstance().smVO.carretas.length > 0)
			{
				for each(var veiculoVO:VeiculoVO in MainModel.getInstance().smVO.carretas)
				{
					with(veiculoVO)
					{
						TrafegusWS.getIntance().salvaVveiViagemVeiculo(salvaVveiViagemVeiculoResultHandler,salvaVveiViagemVeiculoFaultHandler,vveiCodigo,precedencia,cod,vveiMotoPfisPessOrasCodigo,vveiEvcaCodigo,vveiSequencia,vveiUsuarioAdicionou,vveiUsuarioAlterou);
					}
				}
			}
			else
			{
				MainModel.getInstance().terminaisSalvos = 0;
				if(MainModel.getInstance().smVO.terminaisArray.length > 0)
				{
					for each(var terminalVO:TerminalVO in MainModel.getInstance().smVO.terminaisArray)
					{
						with(terminalVO)
						{
							TrafegusWS.getIntance().salvaVterViagemTerminal(salvaVterViagemTerminalResultHandler,salvaVterViagemTerminalFaultHandler,vterCodigo,codigo,precedencia,tempoSatelital,tempoGPRS,vterUsuarioAdicionou,vterUsuarioAlterou,vterDataCadastro);
						}
					}
				}
				else
				{
					with(MainModel.getInstance().smVO.rota.localOrigem)
					{
						TrafegusWS.getIntance().salvaVlocViagemLocal(salvaVlocViagemLocalOrigemResultHandler,salvaVlocViagemLocalOrigemFaultHandler,vlocCodigo,vlocSequencia,codigo,vlocTparCodigo,vlocRaio,vlocDescricao,vlocUsuarioAdicionou,vlocUsuarioAlterou,vlocDataCadastro);
					}
				}
			}
		}
		private function salvaVveiViagemVeiculoPrincipalFaultHandler(event:FaultEvent):void
		{
			MessageBox.informacao("Erro ao salvar VveiViagemVeiculo "+event.fault.message);
			TrafegusWS.getIntance().rollBackTransaction(this.rollBackTransactionResultHandler);
		}
		public function solicitaParadasSM():void
		{
			TrafegusWS.getIntance().solicitaParadasSM(this.solicitaParadasSMResultHandler,MainModel.getInstance().smVO.numeroViagem);
		}
		public function solicitaDadosGridCarretasSM():void
		{
			TrafegusWS.getIntance().solicitaDadosGridCarretasSM(this.solicitaDadosGridCarretasSMResultHandler,MainModel.getInstance().smVO.numeroViagem);
		}
		public function solicitaListaTerminaisSM():void
		{
			TrafegusWS.getIntance().solicitaListaTerminaisSM(this.solicitaListaTerminaisSMResultHandler,MainModel.getInstance().smVO.numeroViagem);
		}
		public function solicitaListaTerminais(placaVeiculo:String):void
		{
			TrafegusWS.getIntance().solicitaListaTerminais(this.solicitaListaTerminaisResultHandler,placaVeiculo);
		}
		private function solicitaParadasSMResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().smVO.paradas.removeAll();
			for each (var obj:Object in resultArray)
			{
				var parada:ParadaVO = new ParadaVO();
				parada.setParadaVO(obj);
				MainModel.getInstance().smVO.paradas.addItem(parada);
			}
		}
		private function solicitaDadosGridCarretasSMResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().smVO.carretas.removeAll();
			for each (var obj:Object in resultArray)
			{
				var carreta:VeiculoVO = new VeiculoVO();
				carreta.setVeiculoVO(obj);
				TrafegusWS.getIntance().solicitaListaTerminais(solicitaListaTerminaisResultHandler,carreta.vehiclePlate);
				MainModel.getInstance().smVO.carretas.addItem(carreta);
			}
			MainModel.getInstance().smVO.carretas.refresh();
		}
		private function solicitaListaTerminaisSMResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				var terminal:TerminalVO = new TerminalVO();
				terminal.setTerminalVO(obj);
				MainModel.getInstance().smVO.terminaisArray.addItem(terminal);
			}
			this.solicitaDadosTerminalDefeituoso();
		}
		private function solicitaListaTerminaisResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				var terminal:TerminalVO = new TerminalVO();
				terminal.setTerminalVO(obj);
				MainModel.getInstance().smVO.terminaisArray.addItem(terminal);
			}
			//this.solicitaDadosTerminalDefeituoso();
		}
		private function solicitaDadosTerminalDefeituoso():void
		{
			MainModel.getInstance().smVO.codTerminais = "";
			for each(var terminal:TerminalVO in MainModel.getInstance().smVO.terminaisArray)
			{
				if(MainModel.getInstance().smVO.codTerminais != "")
				{
					MainModel.getInstance().smVO.codTerminais += ",";
				}
				MainModel.getInstance().smVO.codTerminais += terminal.codigo;
			}
			TrafegusWS.getIntance().solicitaDadosTerminalDefeituoso(solicitaDadosTerminalDefeituosoResultHandler);
		}
		private function solicitaDadosTerminalDefeituosoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().smVO.terminaisDefeituososArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var terminal:TerminalDefeituosoVO = new TerminalDefeituosoVO();
				terminal.setTerminalDefeituosoVO(obj);
				MainModel.getInstance().smVO.terminaisDefeituososArray.addItem(terminal);
			}
		}
	}
}