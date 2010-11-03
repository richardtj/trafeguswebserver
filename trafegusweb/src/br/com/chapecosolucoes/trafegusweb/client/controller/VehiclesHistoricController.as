package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.view.VehiclesHistoricView;
	
	import mx.collections.XMLListCollection;

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
			this.view.dispatchEvent(new DetailsEvent(DetailsEvent.ROUTE_RECEIVED_EVENT));
		}
	}
}