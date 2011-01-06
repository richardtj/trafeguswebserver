package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.LocaisZoom;
	import br.com.chapecosolucoes.trafegusweb.client.enum.PaginableEnum;
	import br.com.chapecosolucoes.trafegusweb.client.events.PGRSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedLocalEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.LocalDetailsView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class LocalZoomController
	{
		public function LocalZoomController()
		{
		}
		public var view:LocaisZoom;
		public function locaisFilterFunction(item:Object):Boolean
		{
			return (String(LocalVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(LocalVO(item).codigoGrupo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(LocalVO(item).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(LocalVO(item).descricaoGrupo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(LocalVO(item).gpsLatitudeString).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(LocalVO(item).gpsLongitudeString).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function solicitaListaLocais(event:PaginableEvent):void
		{
			TrafegusWS.getIntance().solicitaListaLocais(solicitaListaLocaisResultEvent,event.paginaAtual);
		}
		public function atualizaListaLocais():void
		{
			this.view.paginable.paginaAtual=1;
			TrafegusWS.getIntance().solicitaListaLocais(solicitaListaLocaisResultEvent,0);
		}
		private function solicitaListaLocaisResultEvent(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().locaisArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var local:LocalVO = new LocalVO();
				local.setLocalVO(obj);
				MainModel.getInstance().locaisArray.addItem(local);
			}
		}
		public function localSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var localEvent:SelectedLocalEvent = new SelectedLocalEvent(SelectedLocalEvent.SELECTED_LOCAL_EVENT,LocalVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(localEvent);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum local selecionado.");
			}
		}
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);
		}
		public function solicitaTotalListaLocais():void
		{
			TrafegusWS.getIntance().solicitaTotalListaLocais(solicitaTotalListaLocaisResultHandler);
		}
		private function solicitaTotalListaLocaisResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaLocais = int(obj.total.toString());
			}
		}
		public function localSelecionadoEventHandler(event:SelectedLocalEvent):void
		{
			event.stopImmediatePropagation();
			this.localSelecionado();
		}
		public function mouseOverEventHandler():void
		{
			LocalDetailsView.SELECT_BUTTON_VISIBLE = true;
		}
	}
}