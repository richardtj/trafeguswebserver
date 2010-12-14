package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.EmbarcadoresZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.EmbarcadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.vo.EmbarcadorVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class EmbarcadoresZoomController
	{
		public function EmbarcadoresZoomController()
		{
		}
		public var view:EmbarcadoresZoom;
		public function embarcadoresFilterFunction(item:Object):Boolean
		{
			return (String(EmbarcadorVO(item).cnpj).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(EmbarcadorVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(EmbarcadorVO(item).dataCadastro).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(EmbarcadorVO(item).ie).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(EmbarcadorVO(item).nome).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(EmbarcadorVO(item).site).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
			
		}
		public function solicitaListaEmbarcadores():void
		{
			if(MainModel.getInstance().embarcadoresArray.length == 0)
			{
				TrafegusWS.getIntance().solicitaListaEmbarcadores(solicitaListaEmbarcadoresResultEvent);
			}
		}
		public function atualizaListaEmbarcadores():void
		{
			TrafegusWS.getIntance().solicitaListaEmbarcadores(solicitaListaEmbarcadoresResultEvent);
		}
		private function solicitaListaEmbarcadoresResultEvent(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().embarcadoresArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var embarcador:EmbarcadorVO = new EmbarcadorVO();
				embarcador.setEmbarcadorVO(obj);
				MainModel.getInstance().embarcadoresArray.addItem(embarcador);
			}
		}
		public function embarcadorSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var embarcadorEvent:EmbarcadorSelecionadoEvent = new EmbarcadorSelecionadoEvent(EmbarcadorSelecionadoEvent.EMBARCADOR_SELECIONADO_EVENT,EmbarcadorVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(embarcadorEvent);
				this.closeHandler();
			}
			else
			{
				Alert.show("Nenhum embarcador selecionado.");
			}
		}
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);
		}
	}
}