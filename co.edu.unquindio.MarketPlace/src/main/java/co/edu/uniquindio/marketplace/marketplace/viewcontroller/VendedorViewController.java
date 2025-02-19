package co.edu.uniquindio.marketplace.marketplace.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplace.controller.WallController;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class VendedorViewController {

    WallController wallController;
    UsuarioDto usuarioDto;
    VendedorDto vendedorDto;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private SplitMenuButton ActionsCreateReport;

    @FXML
    private SplitMenuButton ActionsSellers;

    @FXML
    private SplitMenuButton ActionsSellers1;

    @FXML
    private SplitMenuButton ActionsSellers11;

    @FXML
    private SplitMenuButton ActionsSellers12;

    @FXML
    private Button AddAComment;

    @FXML
    private Button AddProduct1;

    @FXML
    private Button AddProductProfile;

    @FXML
    private Button AddSeller;

    @FXML
    private Button ButtonDescuento;

    @FXML
    private Button ButtonToBuy;

    @FXML
    private ImageView CartShoppingCart;

    @FXML
    private ButtonBar ChatSinceWindowProducts;

    @FXML
    private ButtonBar ChatSinceWindowProfile;

    @FXML
    private ButtonBar ChatSinceWindowSellers;

    @FXML
    private Button CreateReport;

    @FXML
    private Button CreateReport1;

    @FXML
    private Button CreateReport11;

    @FXML
    private Button DeleteProductYP;

    @FXML
    private Button DeleteSeller;

    @FXML
    private Button DeleteToCart;

    @FXML
    private Button EditPublication;

    @FXML
    private Button EditPublication1;

    @FXML
    private Button NewPublication;

    @FXML
    private ImageView Product8;

    @FXML
    private Button ProductAddedToCart1;

    @FXML
    private Button ProductAddedToCart2;

    @FXML
    private Button ProductAddedToCart3;

    @FXML
    private Button ProductAddedToCart4;

    @FXML
    private Button ProductAddedToCart5;

    @FXML
    private Button ProductAddedToCart6;

    @FXML
    private Button PublicationAdded;

    @FXML
    private AnchorPane PublicationAndComments;

    @FXML
    private Label PublicationDate1;

    @FXML
    private Label PublicationDate2;

    @FXML
    private Label PublicationDate3;

    @FXML
    private Label PublicationDate4;

    @FXML
    private Label PublicationDate5;

    @FXML
    private Label PublicationDate6;

    @FXML
    private Label PublicationTime;

    @FXML
    private Label PublicationTime1;

    @FXML
    private Label PublicationTime2;

    @FXML
    private Label PublicationTime3;

    @FXML
    private Label PublicationTime5;

    @FXML
    private Label PublicationTime6;

    @FXML
    private MenuButton SearchingOptionsProducts;

    @FXML
    private MenuButton SearchingOptionsSellers;

    @FXML
    private MenuButton SearchingOptionsSellers11;

    @FXML
    private MenuButton SearchingOptionsSellers111;

    @FXML
    private MenuButton SearchingOptionsShoppingCart;

    @FXML
    private MenuButton SearchingWall;

    @FXML
    private CheckBox SelectProduct1;

    @FXML
    private CheckBox SelectProduct2;

    @FXML
    private CheckBox SelectProduct3;

    @FXML
    private CheckBox SelectProduct4;

    @FXML
    private CheckBox SelectProduct5;

    @FXML
    private CheckBox SelectProduct6;

    @FXML
    private CheckBox SelectProductForAdd1;

    @FXML
    private CheckBox SelectProductForAdd2;

    @FXML
    private CheckBox SelectProductForAdd3;

    @FXML
    private CheckBox SelectProductForAdd4;

    @FXML
    private CheckBox SelectProductForAdd6;

    @FXML
    private CheckBox SelectProductForAdd7;

    @FXML
    private CheckBox SelectProductForAdd8;

    @FXML
    private CheckBox SelectProductForAdd9;

    @FXML
    private CheckBox SelectPublication;

    @FXML
    private Label TotalPrice;

    @FXML
    private SplitMenuButton Wall;

    @FXML
    private MenuItem brnMenuPrincipalProfile;

    @FXML
    private Button btnAddDescription;

    @FXML
    private Button btnAddToCarProducts;

    @FXML
    private Button btnChatProducts;

    @FXML
    private Button btnChatProfile;

    @FXML
    private Button btnChatSellers;

    @FXML
    private MenuItem btnChatShoppingCar;

    @FXML
    private Button btnComments;

    @FXML
    private Button btnDeleteProductReport;

    @FXML
    private Button btnDeleteProducts;

    @FXML
    private MenuItem btnFavoriteProfile;

    @FXML
    private MenuItem btnFavoritesReport;

    @FXML
    private MenuItem btnFavoritesShoppingCar;

    @FXML
    private MenuItem btnFavoritesWall;

    @FXML
    private MenuItem btnGoShoppingCar;

    @FXML
    private MenuItem btnLogOutProducts;

    @FXML
    private MenuItem btnLogOutProfile;

    @FXML
    private MenuItem btnLogOutReport;

    @FXML
    private MenuItem btnLogOutSellers;

    @FXML
    private MenuItem btnLogOutShoppingCar;

    @FXML
    private MenuItem btnLogOutWall;

    @FXML
    private MenuItem btnMenuPrincipalReport;

    @FXML
    private MenuItem btnMenuPrincipalSellers;

    @FXML
    private MenuItem btnMenuPrincipalShoppingCar;

    @FXML
    private MenuItem btnMenuPrincipalWall;

    @FXML
    private Button btnNewChat;

    @FXML
    private MenuItem btnPrincipalMenu;

    @FXML
    private MenuItem btnProducsSellers;

    @FXML
    private Button btnProduct1;

    @FXML
    private Button btnProduct19;

    @FXML
    private Button btnProduct2;

    @FXML
    private Button btnProduct3;

    @FXML
    private Button btnProduct4;

    @FXML
    private Button btnProduct5;

    @FXML
    private Button btnProduct6;

    @FXML
    private Button btnProduct7;

    @FXML
    private Button btnProduct8;

    @FXML
    private MenuItem btnProductsP;

    @FXML
    private MenuItem btnProductsProfile;

    @FXML
    private MenuItem btnProductsReport;

    @FXML
    private MenuItem btnProductsShoppingCar;

    @FXML
    private MenuItem btnProductsWall;

    @FXML
    private Button btnPublicationProfile;

    @FXML
    private RadioButton btnSeller3;

    @FXML
    private RadioButton btnSeller5;

    @FXML
    private RadioButton btnSeller6;

    @FXML
    private RadioButton btnSeller7;

    @FXML
    private RadioButton btnSeller8;

    @FXML
    private RadioButton btnSeller9;

    @FXML
    private RadioButton btnSellerFour;

    @FXML
    private RadioButton btnSellerOne;

    @FXML
    private RadioButton btnSellerTwo;

    @FXML
    private MenuItem btnSellersShopingCar;

    @FXML
    private MenuItem btnSellersWall;

    @FXML
    private MenuItem btnWallProducts;

    @FXML
    private MenuItem btnWallProfile;

    @FXML
    private MenuItem btnWallReport;

    @FXML
    private MenuItem btnWallSellers;

    @FXML
    private MenuItem btnWallShoppingCar;

    @FXML
    private MenuItem btnYourFavoritesProducts;

    @FXML
    private MenuItem btnYourFavoritesSellers;

    @FXML
    private MenuItem btnYourProfileShoppingCar;

    @FXML
    private TextField comment;

    @FXML
    void OnActionsWindowCreateReport(ActionEvent event) {

    }

    @FXML
    void OnActionsWindowSellers(ActionEvent event) {

    }

    @FXML
    void OnAddAAComment(ActionEvent event) {

    }

    @FXML
    void OnAddContentOfYourComment(ActionEvent event) {

    }

    @FXML
    void OnAddNewPublication(ActionEvent event) {

    }

    @FXML
    void OnAddOnYourFavorites(ActionEvent event) {

    }

    @FXML
    void OnAddProductYourProfile(ActionEvent event) {

    }

    @FXML
    void OnAddSeller(ActionEvent event) {

    }

    @FXML
    void OnAddTitle(ActionEvent event) {

    }

    @FXML
    void OnAddToCarProducts(ActionEvent event) {

    }

    @FXML
    void OnAdddiscount(ActionEvent event) {

    }

    @FXML
    void OnBtnChatProducts(ActionEvent event) {

    }

    @FXML
    void OnBtnChatSellers(ActionEvent event) {

    }

    @FXML
    void OnBtnChatShoppingCar(ActionEvent event) {

    }

    @FXML
    void OnBtnComments(ActionEvent event) {

    }

    @FXML
    void OnBtnDeleteProductReport(ActionEvent event) {

    }

    @FXML
    void OnBtnDeleteProducts(ActionEvent event) {

    }

    @FXML
    void OnBtnFavoriteProfile(ActionEvent event) {

    }

    @FXML
    void OnBtnFavoriteReport(ActionEvent event) {

    }

    @FXML
    void OnBtnFavoritesProducts(ActionEvent event) {

    }

    @FXML
    void OnBtnFavoritesShoppingCar(ActionEvent event) {

    }

    @FXML
    void OnBtnLogOutProfile(ActionEvent event) {

    }

    @FXML
    void OnBtnLogOutReport(ActionEvent event) {

    }

    @FXML
    void OnBtnLogOutSellers(ActionEvent event) {

    }

    @FXML
    void OnBtnLogOutShoppingCar(ActionEvent event) {

    }

    @FXML
    void OnBtnMenuPrincipalProfile(ActionEvent event) {

    }

    @FXML
    void OnBtnMenuPrincipalShoppingCar(ActionEvent event) {

    }

    @FXML
    void OnBtnNewChat(ActionEvent event) {

    }

    @FXML
    void OnBtnPrincipalMenu(ActionEvent event) {

    }

    @FXML
    void OnBtnProductsProfile(ActionEvent event) {

    }

    @FXML
    void OnBtnProductsReport(ActionEvent event) {

    }

    @FXML
    void OnBtnProductsSellers(ActionEvent event) {

    }

    @FXML
    void OnBtnProductsWall(ActionEvent event) {

    }

    @FXML
    void OnBtnPublicationProfile(ActionEvent event) {

    }

    @FXML
    void OnBtnSeller3(ActionEvent event) {

    }

    @FXML
    void OnBtnSeller5(ActionEvent event) {

    }

    @FXML
    void OnBtnSeller6(ActionEvent event) {

    }

    @FXML
    void OnBtnSeller7(ActionEvent event) {

    }

    @FXML
    void OnBtnSeller9(ActionEvent event) {

    }

    @FXML
    void OnBtnSellerFour(ActionEvent event) {

    }

    @FXML
    void OnBtnSellerOne(ActionEvent event) {

    }

    @FXML
    void OnBtnSellerTwo(ActionEvent event) {

    }

    @FXML
    void OnBtnSellersShoppingCar(ActionEvent event) {

    }

    @FXML
    void OnBtnWallProfile(ActionEvent event) {

    }

    @FXML
    void OnBtnWallReport(ActionEvent event) {

    }

    @FXML
    void OnBtnWallShoppingCar(ActionEvent event) {

    }

    @FXML
    void OnBtnYourProfileShoppingCar(ActionEvent event) {

    }

    @FXML
    void OnBuy(ActionEvent event) {

    }

    @FXML
    void OnChatProfile(ActionEvent event) {

    }

    @FXML
    void OnCreateReport(ActionEvent event) {

    }

    @FXML
    void OnDeleteProductYP(ActionEvent event) {

    }

    @FXML
    void OnDeleteSeller(ActionEvent event) {

    }

    @FXML
    void OnDeleteToCart(ActionEvent event) {

    }

    @FXML
    void OnEditPublication(ActionEvent event) {

    }

    @FXML
    void OnGoToChat(MouseEvent event) {

    }

    @FXML
    void OnMenuPrincipalReport(ActionEvent event) {

    }

    @FXML
    void OnMenuPrincipalSellers(ActionEvent event) {

    }

    @FXML
    void OnSearchItemsWall(ActionEvent event) {

    }

    @FXML
    void OnSearchingOptionsProducts(ActionEvent event) {

    }

    @FXML
    void OnSearchingOptionsSellers(ActionEvent event) {

    }

    @FXML
    void OnSearchingOptionsShoppingCart(ActionEvent event) {

    }

    @FXML
    void OnSearchingOptionsWall(ActionEvent event) {

    }

    @FXML
    void OnSelectProductShoppingCart1(ActionEvent event) {

    }

    @FXML
    void OnSelectProductShoppingCart2(ActionEvent event) {

    }

    @FXML
    void OnSelectProductShoppingCart3(ActionEvent event) {

    }

    @FXML
    void OnSelectProductShoppingCart4(ActionEvent event) {

    }

    @FXML
    void OnSelectProductShoppingCart5(ActionEvent event) {

    }

    @FXML
    void OnSelectProductShoppingCart6(ActionEvent event) {

    }

    @FXML
    void OnSelectProductWProducts1(ActionEvent event) {

    }

    @FXML
    void OnSelectProductWProducts2(ActionEvent event) {

    }

    @FXML
    void OnSelectProductWProducts3(ActionEvent event) {

    }

    @FXML
    void OnSelectProductWProducts4(ActionEvent event) {

    }

    @FXML
    void OnSelectProductWProducts6(ActionEvent event) {

    }

    @FXML
    void OnSelectProductWProducts7(ActionEvent event) {

    }

    @FXML
    void OnSelectProductWProducts8(ActionEvent event) {

    }

    @FXML
    void OnSelectProductWProducts9(ActionEvent event) {

    }

    @FXML
    void OnSelectPublication(ActionEvent event) {

    }

    @FXML
    void OnShowNewPublicationAdded(ActionEvent event) {

    }

    @FXML
    void OnShowProduct1(ActionEvent event) {

    }

    @FXML
    void OnShowProduct8(ActionEvent event) {

    }

    @FXML
    void OnShowProductAddedToCart1(ActionEvent event) {

    }

    @FXML
    void OnShowSeller6(MouseEvent event) {

    }

    @FXML
    void OnShowSeller8(ActionEvent event) {

    }

    @FXML
    void OnShowSeller9(MouseEvent event) {

    }

    @FXML
    void OnShowToProduct3(ActionEvent event) {

    }

    @FXML
    void OnShowToProduct4(ActionEvent event) {

    }

    @FXML
    void OnShowToProduct5(ActionEvent event) {

    }

    @FXML
    void OnShowToProduct6(ActionEvent event) {

    }

    @FXML
    void OnShowToProduct7(ActionEvent event) {

    }

    @FXML
    void OnShowToProduct8(MouseEvent event) {

    }

    @FXML
    void OnShowToProduct9(ActionEvent event) {

    }

    @FXML
    void OnShowTotalPrice(MouseEvent event) {

    }

    @FXML
    void OnShowToṔroduct2(ActionEvent event) {

    }

    @FXML
    void OnShowYourPublications(MouseEvent event) {

    }

    @FXML
    void OnbtenProductsShoppingCar(ActionEvent event) {

    }

    @FXML
    void OnbtnLogOutProducts(ActionEvent event) {

    }

    @FXML
    void OnbtnSellersWall(ActionEvent event) {

    }

    @FXML
    void onBtnFavoritesSellers(ActionEvent event) {

    }

    @FXML
    void onBtnFavoritesWall(ActionEvent event) {

    }

    @FXML
    void onBtnMenuPrincipal(ActionEvent event) {

    }

    @FXML
    void onBtnProductsP(ActionEvent event) {

    }

    @FXML
    void onBtnShoppingCar(ActionEvent event) {

    }

    @FXML
    void onBtnWallProducts(ActionEvent event) {

    }

    @FXML
    void onBtnWallSellers(ActionEvent event) {

    }

    @FXML
    void onLogOutBtnWall(ActionEvent event) {

    }

    public void WallController (){
        wallController = new WallController();
    }

    public void inicializarVentana(VendedorDto vendedorDto){
        this.vendedorDto = vendedorDto;
    }

    @FXML
    void initialize() {
        assert ActionsCreateReport != null : "fx:id=\"ActionsCreateReport\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ActionsSellers != null : "fx:id=\"ActionsSellers\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ActionsSellers1 != null : "fx:id=\"ActionsSellers1\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ActionsSellers11 != null : "fx:id=\"ActionsSellers11\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ActionsSellers12 != null : "fx:id=\"ActionsSellers12\" was not injected: check your FXML file 'Wall.fxml'.";
        assert AddAComment != null : "fx:id=\"AddAComment\" was not injected: check your FXML file 'Wall.fxml'.";
        assert AddProduct1 != null : "fx:id=\"AddProduct1\" was not injected: check your FXML file 'Wall.fxml'.";
        assert AddProductProfile != null : "fx:id=\"AddProductProfile\" was not injected: check your FXML file 'Wall.fxml'.";
        assert AddSeller != null : "fx:id=\"AddSeller\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ButtonDescuento != null : "fx:id=\"ButtonDescuento\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ButtonToBuy != null : "fx:id=\"ButtonToBuy\" was not injected: check your FXML file 'Wall.fxml'.";
        assert CartShoppingCart != null : "fx:id=\"CartShoppingCart\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ChatSinceWindowProducts != null : "fx:id=\"ChatSinceWindowProducts\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ChatSinceWindowProfile != null : "fx:id=\"ChatSinceWindowProfile\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ChatSinceWindowSellers != null : "fx:id=\"ChatSinceWindowSellers\" was not injected: check your FXML file 'Wall.fxml'.";
        assert CreateReport != null : "fx:id=\"CreateReport\" was not injected: check your FXML file 'Wall.fxml'.";
        assert CreateReport1 != null : "fx:id=\"CreateReport1\" was not injected: check your FXML file 'Wall.fxml'.";
        assert CreateReport11 != null : "fx:id=\"CreateReport11\" was not injected: check your FXML file 'Wall.fxml'.";
        assert DeleteProductYP != null : "fx:id=\"DeleteProductYP\" was not injected: check your FXML file 'Wall.fxml'.";
        assert DeleteSeller != null : "fx:id=\"DeleteSeller\" was not injected: check your FXML file 'Wall.fxml'.";
        assert DeleteToCart != null : "fx:id=\"DeleteToCart\" was not injected: check your FXML file 'Wall.fxml'.";
        assert EditPublication != null : "fx:id=\"EditPublication\" was not injected: check your FXML file 'Wall.fxml'.";
        assert EditPublication1 != null : "fx:id=\"EditPublication1\" was not injected: check your FXML file 'Wall.fxml'.";
        assert NewPublication != null : "fx:id=\"NewPublication\" was not injected: check your FXML file 'Wall.fxml'.";
        assert Product8 != null : "fx:id=\"Product8\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ProductAddedToCart1 != null : "fx:id=\"ProductAddedToCart1\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ProductAddedToCart2 != null : "fx:id=\"ProductAddedToCart2\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ProductAddedToCart3 != null : "fx:id=\"ProductAddedToCart3\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ProductAddedToCart4 != null : "fx:id=\"ProductAddedToCart4\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ProductAddedToCart5 != null : "fx:id=\"ProductAddedToCart5\" was not injected: check your FXML file 'Wall.fxml'.";
        assert ProductAddedToCart6 != null : "fx:id=\"ProductAddedToCart6\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationAdded != null : "fx:id=\"PublicationAdded\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationAndComments != null : "fx:id=\"PublicationAndComments\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationDate1 != null : "fx:id=\"PublicationDate1\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationDate2 != null : "fx:id=\"PublicationDate2\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationDate3 != null : "fx:id=\"PublicationDate3\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationDate4 != null : "fx:id=\"PublicationDate4\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationDate5 != null : "fx:id=\"PublicationDate5\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationDate6 != null : "fx:id=\"PublicationDate6\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationTime != null : "fx:id=\"PublicationTime\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationTime1 != null : "fx:id=\"PublicationTime1\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationTime2 != null : "fx:id=\"PublicationTime2\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationTime3 != null : "fx:id=\"PublicationTime3\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationTime5 != null : "fx:id=\"PublicationTime5\" was not injected: check your FXML file 'Wall.fxml'.";
        assert PublicationTime6 != null : "fx:id=\"PublicationTime6\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SearchingOptionsProducts != null : "fx:id=\"SearchingOptionsProducts\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SearchingOptionsSellers != null : "fx:id=\"SearchingOptionsSellers\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SearchingOptionsSellers11 != null : "fx:id=\"SearchingOptionsSellers11\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SearchingOptionsSellers111 != null : "fx:id=\"SearchingOptionsSellers111\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SearchingOptionsShoppingCart != null : "fx:id=\"SearchingOptionsShoppingCart\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SearchingWall != null : "fx:id=\"SearchingWall\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProduct1 != null : "fx:id=\"SelectProduct1\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProduct2 != null : "fx:id=\"SelectProduct2\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProduct3 != null : "fx:id=\"SelectProduct3\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProduct4 != null : "fx:id=\"SelectProduct4\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProduct5 != null : "fx:id=\"SelectProduct5\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProduct6 != null : "fx:id=\"SelectProduct6\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProductForAdd1 != null : "fx:id=\"SelectProductForAdd1\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProductForAdd2 != null : "fx:id=\"SelectProductForAdd2\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProductForAdd3 != null : "fx:id=\"SelectProductForAdd3\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProductForAdd4 != null : "fx:id=\"SelectProductForAdd4\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProductForAdd6 != null : "fx:id=\"SelectProductForAdd6\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProductForAdd7 != null : "fx:id=\"SelectProductForAdd7\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProductForAdd8 != null : "fx:id=\"SelectProductForAdd8\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectProductForAdd9 != null : "fx:id=\"SelectProductForAdd9\" was not injected: check your FXML file 'Wall.fxml'.";
        assert SelectPublication != null : "fx:id=\"SelectPublication\" was not injected: check your FXML file 'Wall.fxml'.";
        assert TotalPrice != null : "fx:id=\"TotalPrice\" was not injected: check your FXML file 'Wall.fxml'.";
        assert Wall != null : "fx:id=\"Wall\" was not injected: check your FXML file 'Wall.fxml'.";
        assert brnMenuPrincipalProfile != null : "fx:id=\"brnMenuPrincipalProfile\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnAddDescription != null : "fx:id=\"btnAddDescription\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnAddToCarProducts != null : "fx:id=\"btnAddToCarProducts\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnChatProducts != null : "fx:id=\"btnChatProducts\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnChatProfile != null : "fx:id=\"btnChatProfile\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnChatSellers != null : "fx:id=\"btnChatSellers\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnChatShoppingCar != null : "fx:id=\"btnChatShoppingCar\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnComments != null : "fx:id=\"btnComments\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnDeleteProductReport != null : "fx:id=\"btnDeleteProductReport\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnDeleteProducts != null : "fx:id=\"btnDeleteProducts\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnFavoriteProfile != null : "fx:id=\"btnFavoriteProfile\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnFavoritesReport != null : "fx:id=\"btnFavoritesReport\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnFavoritesShoppingCar != null : "fx:id=\"btnFavoritesShoppingCar\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnFavoritesWall != null : "fx:id=\"btnFavoritesWall\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnGoShoppingCar != null : "fx:id=\"btnGoShoppingCar\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnLogOutProducts != null : "fx:id=\"btnLogOutProducts\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnLogOutProfile != null : "fx:id=\"btnLogOutProfile\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnLogOutReport != null : "fx:id=\"btnLogOutReport\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnLogOutSellers != null : "fx:id=\"btnLogOutSellers\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnLogOutShoppingCar != null : "fx:id=\"btnLogOutShoppingCar\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnLogOutWall != null : "fx:id=\"btnLogOutWall\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnMenuPrincipalReport != null : "fx:id=\"btnMenuPrincipalReport\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnMenuPrincipalSellers != null : "fx:id=\"btnMenuPrincipalSellers\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnMenuPrincipalShoppingCar != null : "fx:id=\"btnMenuPrincipalShoppingCar\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnMenuPrincipalWall != null : "fx:id=\"btnMenuPrincipalWall\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnNewChat != null : "fx:id=\"btnNewChat\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnPrincipalMenu != null : "fx:id=\"btnPrincipalMenu\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProducsSellers != null : "fx:id=\"btnProducsSellers\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProduct1 != null : "fx:id=\"btnProduct1\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProduct19 != null : "fx:id=\"btnProduct19\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProduct2 != null : "fx:id=\"btnProduct2\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProduct3 != null : "fx:id=\"btnProduct3\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProduct4 != null : "fx:id=\"btnProduct4\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProduct5 != null : "fx:id=\"btnProduct5\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProduct6 != null : "fx:id=\"btnProduct6\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProduct7 != null : "fx:id=\"btnProduct7\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProduct8 != null : "fx:id=\"btnProduct8\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProductsP != null : "fx:id=\"btnProductsP\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProductsProfile != null : "fx:id=\"btnProductsProfile\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProductsReport != null : "fx:id=\"btnProductsReport\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProductsShoppingCar != null : "fx:id=\"btnProductsShoppingCar\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnProductsWall != null : "fx:id=\"btnProductsWall\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnPublicationProfile != null : "fx:id=\"btnPublicationProfile\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnSeller3 != null : "fx:id=\"btnSeller3\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnSeller5 != null : "fx:id=\"btnSeller5\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnSeller6 != null : "fx:id=\"btnSeller6\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnSeller7 != null : "fx:id=\"btnSeller7\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnSeller8 != null : "fx:id=\"btnSeller8\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnSeller9 != null : "fx:id=\"btnSeller9\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnSellerFour != null : "fx:id=\"btnSellerFour\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnSellerOne != null : "fx:id=\"btnSellerOne\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnSellerTwo != null : "fx:id=\"btnSellerTwo\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnSellersShopingCar != null : "fx:id=\"btnSellersShopingCar\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnSellersWall != null : "fx:id=\"btnSellersWall\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnWallProducts != null : "fx:id=\"btnWallProducts\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnWallProfile != null : "fx:id=\"btnWallProfile\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnWallReport != null : "fx:id=\"btnWallReport\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnWallSellers != null : "fx:id=\"btnWallSellers\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnWallShoppingCar != null : "fx:id=\"btnWallShoppingCar\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnYourFavoritesProducts != null : "fx:id=\"btnYourFavoritesProducts\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnYourFavoritesSellers != null : "fx:id=\"btnYourFavoritesSellers\" was not injected: check your FXML file 'Wall.fxml'.";
        assert btnYourProfileShoppingCar != null : "fx:id=\"btnYourProfileShoppingCar\" was not injected: check your FXML file 'Wall.fxml'.";
        assert comment != null : "fx:id=\"comment\" was not injected: check your FXML file 'Wall.fxml'.";

    }


/**
    /**
     * Método para mostrar las publicaciones de un vendedor y sus contactos
     * @param idVendedor
     */
   /** public void mostrarPublicaciones(String idVendedor) {
        List<PublicacionDto> publicaciones = vendedorController.obtenerPublicacionesConectados(idVendedor);

        listViewPublicaciones.getItems().clear();
        for (PublicacionDto publicacion : publicaciones) {
            String item = String.format("Fecha: %s - Descripción: %s",
                    publicacion.getFechaPublicacion(), publicacion.getDescripcion());
            listViewPublicaciones.getItems().add(item);
        }
    }

    /**
     * Método que se llama cuando se selecciona una publicación en la ListView
     */
   /** @FXML
    public void onPublicacionSeleccionada() {
        String seleccion = listViewPublicaciones.getSelectionModel().getSelectedItem();
        if (seleccion != null) {
            textAreaDetalles.setText("Detalles de la publicación seleccionada: " + seleccion);
        }
    }

    private void mostrarMensaje(String mensaje) {
        // Crear un nuevo cuadro de diálogo de alerta
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null); // Sin encabezado
        alert.setContentText(mensaje); // Mensaje a mostrar

        // Mostrar el cuadro de diálogo y esperar a que el usuario lo cierre
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        listViewPublicaciones.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            onPublicacionSeleccionada();
        });

        btnAgregarVendedor.setOnAction(event -> {
            String idVendedor = txtIdVendedor.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String cedula = txtCedula.getText();
            String direccion = txtDireccion.getText();
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            VendedorDto vendedor = new VendedorDto(idVendedor,nombre, apellido, cedula, direccion, username, password);
            vendedorController.addVendedor(vendedor);

            boolean agregado = vendedorController.addVendedor(vendedor);
            if (agregado) {
                mostrarMensaje("Vendedor agregado exitosamente.");
                limpiarCampos();
            } else {
                mostrarMensaje("Error al agregar el vendedor. Verifique los datos.");
            }
        });
        btnActualizarVendedor.setOnAction(event -> {
            String idVendedor = txtIdVendedor.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String cedula = txtCedula.getText();
            String direccion = txtDireccion.getText();
            String username = txtUsername.getText();
            String password = txtPassword.getText();


            VendedorDto vendedorActualizado = new VendedorDto(idVendedor, nombre, apellido, direccion, cedula, username, password);

            boolean actualizado = vendedorController.updateVendedor(vendedorActualizado);
            if (actualizado) {
                mostrarMensaje("Vendedor actualizado exitosamente.");
            } else {
                mostrarMensaje("Error al actualizar el vendedor. Verifique los datos.");
            }
        });
    }

    private void limpiarCampos() {
        txtIdVendedor.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtCedula.clear();
        txtDireccion.clear();
        txtUsername.clear();
        txtPassword.clear();
    }**/
}