package nextstep.shoppingcart.ui.view.product.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.composable.DinoTopAppBar
import nextstep.shoppingcart.ui.model.dummyProducts
import nextstep.shoppingcart.ui.view.product.cartlist.ProductCartListActivity
import nextstep.shoppingcart.ui.view.product.detail.ProductDetailActivity

@Composable
fun ProductListScreen() {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DinoTopAppBar(
                text = stringResource(R.string.product_list_title),
                centeredTitle = true,
                actions = {
                    Image(
                        modifier = Modifier
                            .size(48.dp)
                            .padding(10.dp)
                            .clickable {
                                context.startActivity(ProductCartListActivity.newIntent(context))
                            },
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = stringResource(R.string.product_list_shopping_card_content_description)
                    )
                }
            )
        },
    ) { paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier.padding(paddingValues = paddingValues),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = dummyProducts,
                key = { product -> product.name }
            ) {
                ProductListItem(
                    product = it,
                    onClick = { product ->
                        context.startActivity(ProductDetailActivity.newIntent(context, product))
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListPreview() {
    ProductListScreen()
}
