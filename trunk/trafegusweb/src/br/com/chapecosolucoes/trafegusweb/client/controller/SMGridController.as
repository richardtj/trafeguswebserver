package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.MonitoringRequestWiew;
	import br.com.chapecosolucoes.trafegusweb.client.view.SMGrid;
	import br.com.chapecosolucoes.trafegusweb.client.vo.MonitoringRequestVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.display.DisplayObject;
	
	import mx.controls.Alert;
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;
	import mx.rpc.events.ResultEvent;

	public class SMGridController
	{
		public function SMGridController()
		{
		}
		public var view:SMGrid;
		public function solicitaSMVeiculo(placaVeiculo:String):void
		{
			TrafegusWS.getIntance().solicitaSMVeiculo(solicitaSMVeiculoResultHandler,placaVeiculo);
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
				MainModel.getInstance().smVO = MonitoringRequestVO(this.view.grid.selectedItem);
				var monitoringRequest:MonitoringRequestWiew = new MonitoringRequestWiew();
				PopUpManager.addPopUp(monitoringRequest, DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
				PopUpManager.centerPopUp(monitoringRequest);
			}
		}
		public function novaSM():void
		{
			MainModel.getInstance().smVO = new MonitoringRequestVO();
			var monitoringRequest:MonitoringRequestWiew = new MonitoringRequestWiew();
			PopUpManager.addPopUp(monitoringRequest, DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
			PopUpManager.centerPopUp(monitoringRequest);
		}
		public function atualizaListaSM():void
		{
			
		}
		public function smFilterFunction(item:Object):Boolean{
			return (String(MonitoringRequestVO(item).dataCadastro).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).descricaoDestino).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).nomeEmbarcador).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).numeroViagem).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).operacao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).descricaoOrigem).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).placaVeiculo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).prevFim).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).prevInicio).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).terminal).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MonitoringRequestVO(item).nomeTransportador).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function numeroViagemLabelFunction(data:Object):String
		{
			return "";
		}
	}
}