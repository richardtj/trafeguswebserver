package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.DriverDetails;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.XMLListCollection;
	import mx.rpc.events.ResultEvent;

	public class DriverDetailsController
	{
		public function DriverDetailsController()
		{
		}
		public var view:DriverDetails;
		public function solicitaDadosMotorista(value:String):void
		{
			TrafegusWS.getIntance().solicitaDadosMotorista(solicitaDadosMotoristaResultHandler,value);
		}
		private function solicitaDadosMotoristaResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().dadosMotoristaVO.setDadosMotoristaVO(obj);
			}
		}
	}
}