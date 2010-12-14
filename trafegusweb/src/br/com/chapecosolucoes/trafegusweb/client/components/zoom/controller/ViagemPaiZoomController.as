package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ViagemPaiZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.ViagemPaiSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ViagemPaiVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class ViagemPaiZoomController
	{
		public function ViagemPaiZoomController()
		{
		}
		public var view:ViagemPaiZoom;
		public function solicitaListaViagemPai():void
		{
			if(MainModel.getInstance().viagemPaiArray.length == 0)
			{
				TrafegusWS.getIntance().solicitaListaViagemPai(solicitaListaViagemPaiResultHandler);
			}
		}
		public function atualizaListaViagemPai():void
		{
			TrafegusWS.getIntance().solicitaListaViagemPai(solicitaListaViagemPaiResultHandler);
		}
		private function solicitaListaViagemPaiResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().viagemPaiArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var viagemPai:ViagemPaiVO = new ViagemPaiVO();
				viagemPai.setViagemPaiVO(obj);
				MainModel.getInstance().viagemPaiArray.addItem(viagemPai);
			}
		}
		public function viagemPaiFilterFunction(item:Object):Boolean
		{
			return (String(ViagemPaiVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ViagemPaiVO(item).previsaoFim).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ViagemPaiVO(item).previsaoInicio).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function viagemPaiSelecionada():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var viagemPaiSelecionadaEvent:ViagemPaiSelecionadaEvent = new ViagemPaiSelecionadaEvent(ViagemPaiSelecionadaEvent.VIAGEM_PAI_SELECIONADA_EVENT,ViagemPaiVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(viagemPaiSelecionadaEvent);
				this.closeHandler();
			}
			else
			{
				Alert.show("Nenhuma Viagem Selecionada.");
			}
		}
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);
		}
	}
}