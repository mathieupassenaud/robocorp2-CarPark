function DragAndZoom(canvas) {
    function mouseDown(evt) {
        dragStart = evt.point;
    }
    function mouseDrag(evt) {
        var pt = evt.point;
        paper.view.center = new paper.Point(paper.view.center.x - (pt.x - dragStart.x), paper.view.center.y - (pt.y - dragStart.y));
    }
    function mouseUpOut(evt) {
        dragStart = null;
    }
    var dragStart;

    this.populateTool = function (tool) {
        tool.attach('mousedown', mouseDown);
        tool.attach('mousedrag', mouseDrag);
        tool.attach('mouseup', mouseUpOut);
        tool.attach('mouseout', mouseUpOut);
        canvas.addEventListener('DOMMouseScroll', handleScroll);
        canvas.addEventListener('mousewheel', handleScroll);
    }

    var scaleFactor = 1.1;
    var cumulclick = 0;
    var zoom = function (clicks) {
        console.log(clicks);
        cumulclick += clicks/3
        var factor = Math.pow(scaleFactor, cumulclick);
        console.log(cumulclick);
        //paper.view.center = new paper.Point(paper.view.center.x - (pt.x - dragStart.x), paper.view.center.y - (pt.y - dragStart.y));
        console.log(scaleFactor);
        paper.view.zoom = factor;
    };

    var handleScroll = function (evt) {
        console.log("scroll");
        var delta = evt.wheelDelta ? evt.wheelDelta / 40 : evt.detail ? -evt.detail : 0;
        if (delta)
            zoom(delta);
        return evt.preventDefault() && false;
    };
}
;

function DragAndZoom(canvas) {
    function mouseDown(evt) {
        dragStart = evt.point;
    }
    function mouseDrag(evt) {
        var pt = evt.point;
        paper.view.center = new paper.Point(paper.view.center.x - (pt.x - dragStart.x), paper.view.center.y - (pt.y - dragStart.y));
    }
    function mouseUpOut(evt) {
        dragStart = null;
    }
    var dragStart;

    this.populateTool = function (tool) {
        tool.attach('mousedown', mouseDown);
        tool.attach('mousedrag', mouseDrag);
        tool.attach('mouseup', mouseUpOut);
        tool.attach('mouseout', mouseUpOut);
        canvas.addEventListener('DOMMouseScroll', handleScroll);
        canvas.addEventListener('mousewheel', handleScroll);
    }

    var scaleFactor = 1.1;
    var cumulclick = 0;
    var zoom = function (clicks) {
        console.log(clicks);
        cumulclick += clicks/3
        var factor = Math.pow(scaleFactor, cumulclick);
        console.log(cumulclick);
        //paper.view.center = new paper.Point(paper.view.center.x - (pt.x - dragStart.x), paper.view.center.y - (pt.y - dragStart.y));
        console.log(scaleFactor);
        paper.view.zoom = factor;
    };

    var handleScroll = function (evt) {
        console.log("scroll");
        var delta = evt.wheelDelta ? evt.wheelDelta / 40 : evt.detail ? -evt.detail : 0;
        if (delta)
            zoom(delta);
        return evt.preventDefault() && false;
    };
}
;