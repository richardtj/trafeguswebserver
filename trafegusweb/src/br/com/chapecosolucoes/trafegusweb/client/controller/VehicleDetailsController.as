package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.VehicleDetails;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.XMLListCollection;
	import mx.rpc.events.ResultEvent;

	public class VehicleDetailsController
	{
		public function VehicleDetailsController()
		{
		}
		public var view:VehicleDetails;
		public function solicitaDadosVeiculo(placa:String):void{
			TrafegusWS.getIntance().solicitaDadosVeiculo(solicitaDadosVeiculoResultHandler,placa);
		}
		public function solicitaDadosVeiculoResultHandler(event:ResultEvent):void{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().dadosVeiculoVO.setDadosVeiculoVO(obj);
			}
		} 
	}
}