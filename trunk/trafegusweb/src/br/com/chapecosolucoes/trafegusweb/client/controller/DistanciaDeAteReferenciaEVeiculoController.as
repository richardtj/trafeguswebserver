package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller.BaseZoomController;
	import br.com.chapecosolucoes.trafegusweb.client.events.DistanciaEntreReferenciaEVeiculoSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreReferenciaEVeiculoView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteReferenciaEVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	
	import flash.display.DisplayObject;
	
	import mx.controls.dataGridClasses.DataGridColumn;
	import mx.core.FlexGlobals;
	
	public class DistanciaDeAteReferenciaEVeiculoController extends BaseZoomController
	{
		public function DistanciaDeAteReferenciaEVeiculoController()
		{
			super();
		}
		public function adicionar():void
		{
			var distanciaEntreReferenciaEVeiculo:DistanciaEntreReferenciaEVeiculoView = new DistanciaEntreReferenciaEVeiculoView();
			distanciaEntreReferenciaEVeiculo.addEventListener(DistanciaEntreReferenciaEVeiculoSelecionadoEvent.DISTANCIA_ENTRE_REFERENCIA_E_VEICULO_SELECIONADA_EVENT,distanciaEntreReferenciaEVeiculoSelecionadaEventHandler);
			MyPopUpManager.addPopUp(distanciaEntreReferenciaEVeiculo,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(distanciaEntreReferenciaEVeiculo);
		}
		private function distanciaEntreReferenciaEVeiculoSelecionadaEventHandler(event:DistanciaEntreReferenciaEVeiculoSelecionadoEvent):void
		{
			this.view.dispatchEvent(event.clone());
		}
		public function distanciaEntreReferenciaEVeiculoFilterFunction(item:Object):Boolean
		{
			return (String(PosicaoVeiculoVO(DistanciaDeAteReferenciaEVeiculoVO(item).de).vehiclePlate).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
		}
	}
}