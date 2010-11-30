package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.EmbarcadorDetails;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.XMLListCollection;
	import mx.rpc.events.ResultEvent;

	public class EmbarcadorDetailsController
	{
		public function EmbarcadorDetailsController()
		{
		}
		public var view:EmbarcadorDetails;
		public function solicitaDadosEmbarcador(param:String):void{
			TrafegusWS.getIntance().solicitaDadosEmbarcador(solicitaDadosEmbarcadorResultHandler,param);
		}
		private function solicitaDadosEmbarcadorResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().dadosEmbarcadorVO.setDadosEmbarcadorVO(obj);
			}
		}
	}
}