package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.events.DetailsEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.DetailsView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.HistoricoPosicoesVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.ArrayCollection;
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.rpc.events.ResultEvent;

	public class DetailsController
	{
		public function DetailsController()
		{
		}
		public var view:DetailsView;
		public function solicitaHistoricoPosicoes():void
		{
			TrafegusWS.getIntance().solicitaHistoricoPosicoes(this.solicitaHistoricoPosicoesHandler);
		}
		private function solicitaHistoricoPosicoesHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().historicoPosicoesVeiculosArray = new ArrayCollection();
			for each (var obj:Object in resultArray)
			{
				var dataPos:HistoricoPosicoesVeiculoVO = new HistoricoPosicoesVeiculoVO(obj);
				MainModel.getInstance().historicoPosicoesVeiculosArray.addItem(dataPos);
			}
			this.view.dispatchEvent(new DetailsEvent(DetailsEvent.ROUTE_RECEIVED_EVENT));
		}
	}
}