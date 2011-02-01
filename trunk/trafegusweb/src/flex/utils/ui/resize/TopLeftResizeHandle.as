package flex.utils.ui.resize
{
	import flash.display.Graphics;

	public class TopLeftResizeHandle extends ResizeHandle
	{
		public function TopLeftResizeHandle()
		{
			super();
		}
		/**
		 * Positions the resize handle in the bottom right corner of the parent container.
		 * @param parentW the parent container's width
		 * @param parentH the parent container's height
		 */
		override public function setResizeHandlePosition():void {
			if (parent) {
				if (enabled) {
					move(0, 0);
					if (!visible) {
						visible = true;
					}
				} else {
					visible = false;
				}
			}
		}
		override protected function drawResizeHandle(color:uint = 0x666666, alpha:Number = 1):void {
			var rowCount:uint = rows;
			var colCount:uint = columns;
			var dblDot:Number = dotSize * 2;
			// check if an explicit width or height was set, if so then adjust the columns
			if (!isNaN(explicitWidth)) {
				colCount = Math.round((explicitWidth - dblDot)  / dblDot);
			}
			if (!isNaN(explicitHeight)) {
				rowCount = Math.round((explicitHeight - dblDot) / dblDot);
			}
			
			// draw the triangle, e.g.
			// . . .
			// . . 
			// . 
			var dx:Number, dy:Number;
			var max:Number = Math.min(rowCount, colCount) + 1;
			for (var col:uint = colCount; col > 0; col--) {
				dx = dblDot + (col * dblDot);
				for (var row:uint = rowCount; row > 0; row--) {
					if ((row + col) <= max) {
						dy = dblDot + (row * dblDot); 
						drawDot(color, alpha, dx, dy, dotSize, dotSize);
					}
				}
			}
		}
	}
}