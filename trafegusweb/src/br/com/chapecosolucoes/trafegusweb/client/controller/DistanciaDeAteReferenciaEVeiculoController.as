package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller.BaseZoomController;
	import br.com.chapecosolucoes.trafegusweb.client.events.DistanciaEntreReferenciaEVeiculoSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.LimparDistanciasEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreReferenciaEVeiculoView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteReferenciaEVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;
	
	import flash.display.DisplayObject;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.controls.dataGridClasses.DataGridColumn;
	import mx.core.FlexGlobals;
	import mx.events.ItemClickEvent;
	import mx.events.ListEvent;
	
	public class DistanciaDeAteReferenciaEVeiculoController extends BaseZoomController
	{
		public function DistanciaDeAteReferenciaEVeiculoController()
		{
			super();
		}
		public function adicionar():void
		{
			var distanciaEntreReferenciaEVeiculo:DistanciaEntreReferenciaEVeiculoView = new DistanciaEntreReferenciaEVeiculoView();
			distanciaEntreReferenciaEVeiculo.addEventListener(DistanciaEntreReferenciaEVeiculoSelecionadoEvent.DISTANCIA_ENTRE_REFERENCIA_E_VEICULO_ADICIONADA_EVENT,distanciaEntreReferenciaEVeiculoAdicionadaEventHandler);
			MyPopUpManager.addPopUp(distanciaEntreReferenciaEVeiculo,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(distanciaEntreReferenciaEVeiculo);
		}
		public function remover():void
		{
			var event:LimparDistanciasEvent = new LimparDistanciasEvent(LimparDistanciasEvent.LIMPAR_DISTANCIAS_EVENT,new ArrayCollection(this.view.grid.selectedItems));
			this.view.dispatchEvent(event);
		}
		private function distanciaEntreReferenciaEVeiculoAdicionadaEventHandler(event:DistanciaEntreReferenciaEVeiculoSelecionadoEvent):void
		{
			this.view.dispatchEvent(event.clone());
		}
		public function distanciaEntreReferenciaEVeiculoFilterFunction(item:Object):Boolean
		{
			return (String(PosicaoVeiculoVO(DistanciaDeAteReferenciaEVeiculoVO(item).de).vehiclePlate).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(PosicaoVeiculoVO(DistanciaDeAteReferenciaEVeiculoVO(item).de).gpsDescSis).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(PosicaoVeiculoVO(DistanciaDeAteReferenciaEVeiculoVO(item).de).dataEHora).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ReferenciaVO(DistanciaDeAteReferenciaEVeiculoVO(item).ate).refeDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ReferenciaVO(DistanciaDeAteReferenciaEVeiculoVO(item).ate).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DistanciaDeAteVO(item).distanciaDeAte()).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function itemClickEventHandler(event:ListEvent):void
		{
			var distanciaEntreReferenciaEVeiculoSelecionadoEvent:DistanciaEntreReferenciaEVeiculoSelecionadoEvent = new DistanciaEntreReferenciaEVeiculoSelecionadoEvent(DistanciaEntreReferenciaEVeiculoSelecionadoEvent.DISTANCIA_ENTRE_REFERENCIA_E_VEICULO_SELECIONADA_EVENT,DistanciaDeAteReferenciaEVeiculoVO(event.itemRenderer.data));
			this.view.dispatchEvent(distanciaEntreReferenciaEVeiculoSelecionadoEvent);
		}
	}
}