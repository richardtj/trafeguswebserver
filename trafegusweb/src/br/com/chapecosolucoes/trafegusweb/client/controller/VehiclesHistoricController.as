package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.events.VehiclesHistoricEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.VehiclesHistoricView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.HistoricoPosicoesVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.ArrayCollection;
	import mx.collections.XMLListCollection;
	import mx.rpc.events.ResultEvent;

	public class VehiclesHistoricController
	{
		public function VehiclesHistoricController()
		{
			
		}
		public var view:VehiclesHistoricView;
		
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
			this.view.dispatchEvent(new VehiclesHistoricEvent(VehiclesHistoricEvent.ROUTE_RECEIVED_EVENT,true));
		}
	}
}