package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.enum.SMEnum;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.model.SMGridModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.MonitoringRequestWiew;
	import br.com.chapecosolucoes.trafegusweb.client.view.SMGrid;
	import br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.MonitoringRequestVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ParadaVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.RouteVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TerminalDefeituosoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TerminalVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.display.DisplayObject;
	
	import mx.controls.Alert;
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;
	import mx.rpc.events.ResultEvent;
	import mx.utils.ObjectUtil;

	public class SMGridController
	{
		public function SMGridController()
		{
		}
		public var view:SMGrid;
		public var model:SMGridModel;
		public function solicitaSMVeiculo(event:PaginableEvent):void
		{
			TrafegusWS.getIntance().solicitaSMVeiculo(solicitaSMVeiculoResultHandler,this.model.placaVeiculo,event.paginaAtual);
		}
		public function solicitaTotalSMVeiculo():void
		{
			TrafegusWS.getIntance().solicitaTotalSMVeiculo(solicitaTotalSMVeiculoResultHandler,this.model.placaVeiculo);
		}
		private function solicitaTotalSMVeiculoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalSMVeiculo = int(obj.total.toString());
			}
		}
		private function solicitaSMVeiculoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().smArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var smvo:MonitoringRequestVO = new MonitoringRequestVO();
				smvo.setMonitoringRequestVO(obj);
				MainModel.getInstance().smArray.addItem(smvo);
			}
		}
		public function editarSM():void
		{
			if(this.view.grid.selectedIndex == -1)
			{
				MessageBox.informacao("Nenhuma SM Selecionada");
			}
			else
			{
				var monitoringRequest:MonitoringRequestWiew = new MonitoringRequestWiew();
				monitoringRequest.enum = SMEnum.EDITAR;
				monitoringRequest.smVO = MonitoringRequestVO(this.view.grid.selectedItem);
				MyPopUpManager.addPopUp(monitoringRequest, DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(monitoringRequest);
			}
		}
		
		public function novaSM():void
		{
			
			var monitoringRequest:MonitoringRequestWiew = new MonitoringRequestWiew();
			monitoringRequest.enum = SMEnum.NOVA;
			monitoringRequest.smVO = new MonitoringRequestVO();
			monitoringRequest.smVO.veiculoPrincipal.cod = this.model.codVeic;
			monitoringRequest.smVO.codigoTransportador = ObjectUtil.toString(MainModel.getInstance().codEmpresa);
			monitoringRequest.smVO.veiculoPrincipal.vehiclePlate = this.model.placaVeiculo;
			monitoringRequest.smVO.codigoMotorista = this.model.codigoMotoristaPrincipal;
			MyPopUpManager.addPopUp(monitoringRequest, DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(monitoringRequest);
		}
		public function atualizaListaSM():void
		{
			this.view.paginable.paginaAtual = 1;
			TrafegusWS.getIntance().solicitaSMVeiculo(solicitaSMVeiculoResultHandler,this.model.placaVeiculo,0);
		}
		public function smFilterFunction(item:Object):Boolean{
			return (String(MonitoringRequestVO(item).dataCadastro).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(LocalVO(RouteVO(MonitoringRequestVO(item).rota).localDestino).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).nomeEmbarcador).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).numeroViagem).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).operacao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(LocalVO(RouteVO(MonitoringRequestVO(item).rota).localOrigem).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(VeiculoVO(MonitoringRequestVO(item).veiculoPrincipal).vehiclePlate).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).prevFim).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).prevInicio).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).terminal).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).nomeTransportador).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
	}
}