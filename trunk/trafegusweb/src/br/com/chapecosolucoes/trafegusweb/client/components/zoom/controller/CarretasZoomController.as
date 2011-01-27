package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.CarretaSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.XMLListCollection;
	import mx.rpc.events.ResultEvent;

	public class CarretasZoomController extends BaseZoomController
	{
		public function CarretasZoomController()
		{
			super();
		}
		public function solicitaListaCarretasDisponiveis():void
		{
			if(MainModel.getInstance().carretasDisponiveisArray.length == 0 && MainModel.getInstance().smVO.carretas.length == 0)
			{
				TrafegusWS.getIntance().solicitaListaCarretasDisponiveis(solicitaListaCarretasDisponiveisResultHandler);
			}
		}
		public function atualizaListaCarretasDisponiveis():void
		{
			TrafegusWS.getIntance().solicitaListaCarretasDisponiveis(solicitaListaCarretasDisponiveisResultHandler);
		}
		private function solicitaListaCarretasDisponiveisResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().carretasDisponiveisArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var veiculo:VeiculoVO = new VeiculoVO();
				veiculo.setVeiculoVO(obj);
				MainModel.getInstance().carretasDisponiveisArray.addItem(veiculo);
			}
		}
		public function carretasFilterFunction(item:Object):Boolean
		{
			return (String(VeiculoVO(item).vehiclePlate).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(VeiculoVO(item).desc).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function carretaSelecionada():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var carretaSelecionadaEvent:CarretaSelecionadaEvent = new CarretaSelecionadaEvent(CarretaSelecionadaEvent.CARRETA_SELECIONADA_EVENT,VeiculoVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(carretaSelecionadaEvent);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhuma carreta selecionada.");
			}
		}
	}
}