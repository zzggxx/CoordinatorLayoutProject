
# CoordinatorLayout

添加依赖:
```java
compile 'com.android.support:design:24.2.1'
```
CoordinatorLayout：协调内部子控件间的滚动事件，通常作为**最外层**的布局使用，通过配置**CoordinatorLayout.Behavior**这个行为属性，可以控制其内部子控件间的联动效果，AppBarLayout和FloatingActionButton具有默认的Behavior实现

注意:

1. CorrdinatorLayout只可以捕获到实现了NestedScrollingChild接口的子view的滚动事件，然后分发给其他内部子view
    * RecyclerView
    * NestedScrollView和ScrollView一样效果，但是他可以被捕获事件
    * SwipeRefreshLayout

2. AppBarLayout中的子view是否响应滚动事件，通过给子view配置app:layout_scrollFlags属性来指定不同的滚动事件响应
[动态效果展示](https://blog.csdn.net/losingcarryjie/article/details/78917423)
    * scroll（常用） 响应滚动事件，必须配置这个属性，列表上滚头部滚出去,下滚必须要列表第一个出来之后头部才下来.
        1. scroll|enterAlways :列表上滚头部滚出去,下滚轻轻一滚动头部就会滚下来.
        2. layout_scrollFlags=”scroll|enterAlways|enterAlwaysCollapsed”  相应控件minHeight="50dp":滚出屏幕时还是和以前一样，但是滚入屏幕时，TabLayout会和RecyclerView一起滚入50dp，然后等RecyclerView滚入到边界的时候再滚入剩下的50dp.
        3. layout_scrollFlags=”scroll|exitUntilCollapsed” minHeight="50dp":有滚入限制就会有滚出限制，如图所示，TabLayout不能完全滚出屏幕，
        最少也得留在屏幕上50dp,当滚入屏幕时，等RecyclerView到达边界的时候才会继续滚入
        4. layout_scrollFlags=”scroll|snap”:这个属性很简单，就是设置吸附性效果，当你滚动TabLayout不足一半高度的时候就会回弹，
        高于一半的时候就会全部隐藏（即要么全部显示，要么全部隐藏）
    * enterAlways（常用） 滚动事件向下，配置该属性的子view就会向下滚动进入
    * enterAlwaysCollapsed 滚动事件向下，子view也配置了最小高度，那么向下滚动时，子view会以最小高度进入，只有当被监听的view滚动到顶端时，子view才会以最大高度展开
    * snap 该属性会判断子view底部能看到多少，如果只能看到25%，那么缩回去，如果能看到75%，那么完全显示
    * exitUntilCollapsed（常用） 子view滚出屏幕时，待其完全折叠之后才滚动，从用在CollapsingToolbarLayout中

3. AppBarLayout中的子view需要滚动的，必须放在最顶部，否则滚不动