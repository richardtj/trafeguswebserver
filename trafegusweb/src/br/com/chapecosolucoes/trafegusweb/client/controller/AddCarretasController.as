package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.AddCarretasView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO;
	
	import flash.events.MouseEvent;
	
	import mx.events.DragEvent;
	import mx.managers.PopUpManager;

	public class AddCarretasController
	{
		public function AddCarretasController()
		{
		}
		public var view:AddCarretasView;
		public function leftToRightEventHandler():void
		{
			for each(var vo:VeiculoVO in this.view.grid.selectedItems)
			{
				var veiculoVO:VeiculoVO = VeiculoVO(MainModel.getInstance().veiculosArray.removeItemAt(MainModel.getInstance().veiculosArray.getItemIndex(vo)));
				MainModel.getInstance().veiculosSelecionadosArray.addItem(veiculoVO);
			}
		}
		public function rightToLeftEventHandler():void
		{
			for each(var vo:VeiculoVO in this.view.grid1.selectedItems)
			{
				var veiculoVO:VeiculoVO = VeiculoVO(MainModel.getInstance().veiculosSelecionadosArray.removeItemAt(MainModel.getInstance().veiculosSelecionadosArray.getItemIndex(vo)));
				MainModel.getInstance().veiculosArray.addItem(veiculoVO);
			}
		}
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);
		}
	}
}