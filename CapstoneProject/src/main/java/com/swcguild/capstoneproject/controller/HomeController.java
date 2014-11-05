package com.swcguild.capstoneproject.controller;

import com.swcguild.capstoneproject.dao.interfaces.AssetInterface;
import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Category;
import com.swcguild.capstoneproject.model.Event;
import com.swcguild.capstoneproject.model.notes.AssetNote;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/"})
public class HomeController {

    private static final String BAD_CATEGORY_ERROR_MESSAGE = "Oops! Invalid category ID. Must supply category ID as an integer. Category ID must refer to an existing category.";
    private static final String BAD_ASSET_TYPE_ERROR_MESSAGE = "Oops! Invalid asset type ID. Must supply asset type ID as an integer. Asset type ID must refer to an existing asset type.";

    private AssetInterface assetDao;
    private EventInterface eventDao;
    
    @Inject
    public void setEventDao(EventInterface eventDao) {
        this.eventDao = eventDao;
    }
    
    @Inject
    public HomeController(AssetInterface assetDao) {
        this.assetDao = assetDao;
    }

    

    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String home(Model model) {
        Set<Event> eventList = eventDao.getAllEvents();
        model.addAttribute("eventList", eventList);
        return "index";
    }

    //List Pages
    @RequestMapping(value = {"/assets"}, method = RequestMethod.GET)
    public String displayBrowseAssets(Model model, HttpServletRequest request) {
        Set<AssetType> types = getSelectedAssetTypes(request.getParameter("selectCategory"));
        model.addAttribute("categoryList", assetDao.getAllCategories());
        model.addAttribute("assetTypeList", types);

        return "browseAssets";
    }

    @RequestMapping(value = {"/manage_assets"}, method = RequestMethod.GET)
    public String displayManageAssets(Model model, HttpServletRequest request) {
        Set<AssetType> types = getSelectedAssetTypes(request.getParameter("selectCategory"));

        //error messages
        String badCategoryError = request.getParameter("badCategoryError");
        model.addAttribute("badCategoryError", badCategoryError);

        String badAssetTypeError = request.getParameter("badAssetTypeError");
        model.addAttribute("badAssetTypeError", badAssetTypeError);

        //populating display
        model.addAttribute("categoryList", assetDao.getAllCategories());
        model.addAttribute("assetTypeList", types);
        model.addAttribute("category", new Category());
        return "manageAssets";
    }

    @RequestMapping(value = {"/listAssets"}, method = RequestMethod.GET)
    public String displayAssetListingForType(@ModelAttribute("typeId") int typeId, Model model, HttpServletRequest request) {
        AssetType typeSelected = assetDao.getAssetTypeById(typeId);

        model.addAttribute("assetList", assetDao.getAllAssetsByAssetType(typeSelected));

        return "assetsByType";
    }

    @RequestMapping(value = {"/listAssetNotes"}, method = RequestMethod.GET)
    public String listAssetNotes(Model model, HttpServletRequest request) {
        int assetId;

        try {
            assetId = Integer.parseInt(request.getParameter("assetId"));
            Asset asset = assetDao.getAssetById(assetId);
            model.addAttribute("asset", asset);
            model.addAttribute("assetNotes", assetDao.getAssetNotes(assetId));
        } catch (Exception e) {
            model.addAttribute("listAssetNotesError", "Oops! Something went wrong when attempting to list notes for the selected asset.");
            return "redirect:manage_assets";
        }

        return "viewAssetNotes";
    }

    //Asset Forms
    @RequestMapping(value = {"/addAsset"}, method = RequestMethod.GET)
    public String displayAddAsset(Model model) {
        model.addAttribute("assetTypes", assetDao.getAllAssetTypes());

        model.addAttribute("newAsset", new Asset());

        return "addAsset";
    }

    @RequestMapping(value = {"/updateAsset"}, method = RequestMethod.GET)
    public String displayEditAsset(Model model, HttpServletRequest request) {
        int assetId = 0;

        try {
            assetId = Integer.parseInt(request.getParameter("assetId"));

            model.addAttribute("assetTypes", assetDao.getAllAssetTypes());

            model.addAttribute("asset", assetDao.getAssetById(assetId));

        } catch (Exception e) {
            request.setAttribute("displayUpdateAssetFormError", "Oops! Something went wrong when loading the form. Please try again.");
            //model.addAttribute("displayUpdateAssetFormError", "Oops! Something went wrong when loading the form. Please try again.");
            return "redirect:manage_assets";
        }

        return "editAsset";
    }

    //AssetType Forms
    @RequestMapping(value = {"/addAssetType"}, method = RequestMethod.GET)
    public String displayAddAssetType(Model model, HttpServletRequest request) {
        //error message
        String badCategoryError = request.getParameter("badCategoryError");
        model.addAttribute("badCategoryError", badCategoryError);

        //populating drop-down menu
        model.addAttribute("categoryList", assetDao.getAllCategories());

        //supplying empty asset type
        model.addAttribute("newAssetType", new AssetType());

        return "addAssetType";
    }

    @RequestMapping(value = {"/updateAssetType"}, method = RequestMethod.GET)
    public String displayEditAssetType(Model model, HttpServletRequest request) {
        int assetTypeId;
        //error message
        String badCategoryError = request.getParameter("badCategoryError");
        model.addAttribute("badCategoryError", badCategoryError);

        //get asset type id
        try {
            assetTypeId = Integer.parseInt(request.getParameter("typeId"));
        } catch (NumberFormatException e) {
            request.setAttribute("badAssetTypeError", BAD_ASSET_TYPE_ERROR_MESSAGE);
            return "redirect:manage_assets";
        }

        //populate drop-down
        model.addAttribute("categoryList", assetDao.getAllCategories());

        //retrieve asset type to be updated
        model.addAttribute("assetType", assetDao.getAssetTypeById(assetTypeId));

        return "editAssetType";
    }

    //Category Forms
    @RequestMapping(value = {"/updateCategory"}, method = RequestMethod.GET)
    public String displayEditCategory(Model model, HttpServletRequest request) {
        int categoryId;

        try {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));

            model.addAttribute("category", assetDao.getCategoryById(categoryId));
        } catch (NumberFormatException e) {
            request.setAttribute("displayUpdateCategoryFormError", "Oops! Something went wrong when loading the form. Please try again.");
            return "redirect:manage_assets";
        }

        return "editCategory";
    }

    //AssetNote Form
    @RequestMapping(value = {"/assetAddNote"}, method = RequestMethod.GET)
    public String displayAddAssetNote(Model model, HttpServletRequest request) {
        int assetId = 0;
        AssetNote newNote = new AssetNote();
        Asset asset;
        try {
            assetId = Integer.parseInt(request.getParameter("assetId"));
            //request.setAttribute("assetId", assetId);
            newNote.setAssetId(assetId);
            asset = assetDao.getAssetById(assetId);
            model.addAttribute("assetNote", newNote);
            model.addAttribute("asset", asset);
            model.addAttribute("assetNoteList", assetDao.getAssetNotes(assetId));
        } catch (Exception e) {
            return "redirect:manage_assets";
        }

        return "assetAddNote";
    }

    //Asset CRUD
    @RequestMapping(value = {"/submitNewAsset"}, method = RequestMethod.POST)
    public String submitNewAsset(@Valid Asset newAsset, BindingResult result, Model model, @RequestParam("typeId") int typeId, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "redirect:addAsset";
        }

        newAsset.setAssetType(assetDao.getAssetTypeById(typeId));

        assetDao.addAsset(newAsset);

        model.addAttribute("typeId", typeId);
        return "redirect:listAssets";
    }

    @RequestMapping(value = {"/submitAssetUpdate"}, method = RequestMethod.POST)
    public String submitAssetUpdate(@Valid Asset asset, BindingResult result, Model model, HttpServletRequest request) {
        //get assetTypeId associated with asset
        //asset type not passed as part of asset on model
        int typeId = assetDao.getAssetById(asset.getAssetId()).getAssetType().getAssetTypeId();

        model.addAttribute("typeId", typeId);

        if (result.hasErrors()) {

            return "redirect:updateAsset";
        }

        assetDao.editAsset(asset);

        return "redirect:listAssets";
    }

    @RequestMapping(value = {"/removeAsset"}, method = RequestMethod.GET)
    public String deleteAsset(Model model, HttpServletRequest request, @RequestParam("assetId") int assetId
    ) {
        //int assetId = 0;
        Asset asset;
        try {
            //assetId = Integer.parseInt(request.getParameter("assetId"));
            asset = assetDao.getAssetById(assetId);

            assetDao.deleteAsset(asset);
        } catch (Exception e) {
            request.setAttribute("assetDeletionError", "Oops! Something went wrong when attempting to delete asset.");
        }
        return "redirect:manage_assets";
    }

    //AssetType CRUD
    @RequestMapping(value = {"/submitNewAssetType"}, method = RequestMethod.POST)
    public String submitNewAssetType(@Valid AssetType newAssetType, BindingResult result, Model model, HttpServletRequest request
    ) {
        int categoryId;
        try {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));
        } catch (NumberFormatException e) {
            categoryId = 0;
        }

        if (result.hasErrors() || assetDao.getCategoryById(categoryId) == null) {
            if (true) {
                model.addAttribute("badCategoryError", BAD_CATEGORY_ERROR_MESSAGE);
            }

            return "redirect:addAssetType";
        }

        newAssetType.setCategory(assetDao.getCategoryById(categoryId));
        assetDao.addAssetType(newAssetType);
        return "redirect:manage_assets";
    }

    @RequestMapping(value = {"/submitAssetTypeUpdate"}, method = RequestMethod.POST)
    public String submitAssetTypeUpdate(@Valid AssetType assetType, BindingResult result, Model model, HttpServletRequest request
    ) {
        int categoryId;
        try {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));
        } catch (NumberFormatException e) {
            categoryId = 0;
        }

        if (result.hasErrors() || assetDao.getCategoryById(categoryId) == null) {
            if (true) {
                model.addAttribute("badCategoryError", BAD_CATEGORY_ERROR_MESSAGE);
            }

            model.addAttribute("typeId", assetType.getAssetTypeId());
            return "redirect:updateAssetType";
        }

        assetType.setCategory(assetDao.getCategoryById(categoryId));
        assetDao.editAssetType(assetType);
        return "redirect:manage_assets";
    }

    @RequestMapping(value = {"/removeAssetType"}, method = RequestMethod.GET)
    public String deleteAssetType(Model model, HttpServletRequest request
    ) {
        AssetType assetType;
        int assetTypeId = 0;
        try {
            assetTypeId = Integer.parseInt(request.getParameter("typeId"));

            assetType = assetDao.getAssetTypeById(assetTypeId);

            assetDao.deleteAssetType(assetType);
        } catch (Exception e) {
            request.setAttribute("assetTypeDeletionError", "Oops! Something went wrong when attempting to delete asset type.");
        }
        return "redirect:manage_assets";
    }

    //Category CRUD
    @RequestMapping(value = {"/submitNewCategory"}, method = RequestMethod.POST)
    public String submitNewAssetType(@Valid Category category, BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "redirect:manage_assets";
        }

        assetDao.addCategory(category);

        return "redirect:manage_assets";
    }

    @RequestMapping(value = {"/submitCategoryUpdate"}, method = RequestMethod.POST)
    public String submitCategoryUpdate(@Valid Category category, BindingResult result, Model model, HttpServletRequest request
    ) {
        if (result.hasErrors()) {
            return "redirect:manage_assets";
        }

//        try {
        assetDao.editCategory(category);
//        } catch (Exception e) {
//            request.setAttribute("categoryUpdateError", "Oops! Something went wrong when updating asset. Please try again.");
//        }
        return "redirect:manage_assets";
    }

    @RequestMapping(value = {"/removeCategory"}, method = RequestMethod.GET)
    public String deleteCategory(Model model, HttpServletRequest request
    ) {
        Category category;
        int categoryId = 0;
        try {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));

            category = assetDao.getCategoryById(categoryId);

            assetDao.deleteCategory(category);
        } catch (Exception e) {
            request.setAttribute("categoryDeletionError", "Oops! Something went wrong when attempting to delete asset.");
        }
        return "redirect:manage_assets";
    }

    //AssetNoteCRUD
    @RequestMapping(value = {"/submitNewAssetNote"}, method = RequestMethod.POST)
    public String submitNewAssetNote(@Valid AssetNote newAssetNote, BindingResult result, Model model, HttpServletRequest request) {
        int typeId;
        int assetId;
        if (result.hasErrors()) {
            return "redirect:assetAddNote";
        }

        assetId = newAssetNote.getAssetId();
        typeId = assetDao.getAssetById(assetId).getAssetType().getAssetTypeId();

        assetDao.addNoteToAsset(newAssetNote.getAssetId(), newAssetNote.getNote(), newAssetNote.getCategory());
        model.addAttribute("typeId", typeId);
        return "redirect:listAssets";
    }

    //Helper Methods
    private Set<AssetType> getSelectedAssetTypes(String categoryName) {
        Set<Category> categories = assetDao.getAllCategories();
        Set<AssetType> types = new HashSet<>();
        Category selectedCat = null;
        //String catName = request.getParameter("searchByCategory");

        //find desired category, if selected, and get asset types for category
        if (categoryName != null) {
            for (Category cat : categories) {
                if (cat.getCategoryName().equalsIgnoreCase(categoryName)) {
                    selectedCat = cat;
                    types.addAll(assetDao.getAssetTypeByCategory(cat));
                }
            }
        }

        //get all asset types if no category selected
        if (selectedCat == null /* || catName == null || catName.equalsIgnoreCase("All")*/) {
            for (Category cat : categories) {
                types.addAll(assetDao.getAssetTypeByCategory(cat));
            }
        }

        return types;
    }
}
