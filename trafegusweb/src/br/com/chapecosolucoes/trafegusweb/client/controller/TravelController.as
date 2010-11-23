package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.TravelView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoViagemVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.XMLListCollection;
	import mx.rpc.events.ResultEvent;

	public class TravelController
	{
		public function TravelController()
		{
		}
		public var view:TravelView;
		public function solicitaDadosGridEmViagem():void
		{
			TrafegusWS.getIntance().solicitaDadosGridEmViagem(solicitaDadosGridEmViagemResultHandler);
		}
		public function solicitaDadosGridEmViagemResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().veiculosViagemArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var dataPos:VeiculoViagemVO = new VeiculoViagemVO(obj);
				MainModel.getInstance().veiculosViagemArray.addItem(dataPos);
			}
		}
	}
}