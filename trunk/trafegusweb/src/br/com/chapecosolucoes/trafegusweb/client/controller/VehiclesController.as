package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.VehiclesView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.rpc.events.ResultEvent;
	import mx.utils.ObjectUtil;

	public class VehiclesController
	{
		public function VehiclesController()
		{
			MainModel.getInstance().dpPosicao.filterFunction = veiculosFilterFunction;
		}
		public var view:VehiclesView;
		public function veiculosFilterFunction(item:Object):Boolean
		{
			return String(item.vehiclePlate).toUpperCase().search(MainModel.getInstance().veiculoSelecionado.toUpperCase()) >= 0;
		}
		public function solicitaListaVeiculos():void
		{
			TrafegusWS.getIntance().solicitaListaVeiculos(this.veiculoSelecionadoHandler);
		}
		public function veiculoSelecionado(event:MouseEvent):void
		{
			MainModel.getInstance().posicaoVeiculoVO = PosicaoVeiculoVO(this.view.veiculos.selectedItem);
		}
		private function veiculoSelecionadoHandler(event:ResultEvent):void
		{
			Alert.show(ObjectUtil.toString(event.result));
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.Results.Row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().dpPosicao = new ArrayCollection();
			MainModel.getInstance().dpPosicao.filterFunction = veiculosFilterFunction
			for each (var obj:Object in resultArray)
			{
				var dataPos:PosicaoVeiculoVO = new PosicaoVeiculoVO(obj);
				MainModel.getInstance().dpPosicao.addItem(dataPos);
			}
		}
	}
}