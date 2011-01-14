package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PosicaoVeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.ArrayCollection;
	import mx.collections.XMLListCollection;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class PosicaoVeiculoZoomController
	{
		public function PosicaoVeiculoZoomController()
		{
		}
		public var view:PosicaoVeiculoZoom;
		public function solicitaDadosGrid(event:PaginableEvent):void
		{
			//var paginableEvent:PaginableEvent = new PaginableEvent(PaginableEvent.PAGE_CHANGED,(event.paginaAtual/20)+1);
			//this.view.dispatchEvent(paginableEvent);
			TrafegusWS.getIntance().solicitaDadosGrid(this.dadosGridRecebidosHandler,event.paginaAtual);
		}
		private function dadosGridRecebidosHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().posVeiculosArrayZoom = new ArrayCollection();
			MainModel.getInstance().posVeiculosArrayZoom.filterFunction = posicaoVeiculosFilterFunction;
			for each (var obj:Object in resultArray)
			{
				var dataPos:PosicaoVeiculoVO = new PosicaoVeiculoVO(obj);
				MainModel.getInstance().posVeiculosArrayZoom.addItem(dataPos);
			}
			//this.view.dispatchEvent(new VehiclesEvent(VehiclesEvent.VEHICLES_RECEIVED_EVENT));
		}
		public function posicaoVeiculosFilterFunction(item:Object):Boolean
		{
			return (String(PosicaoVeiculoVO(item).vehiclePlate).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) || 
				(String(PosicaoVeiculoVO(item).gpsDescSis).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function veiculoSelecionado():void
		{
			
		}
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);
		}
	}
}