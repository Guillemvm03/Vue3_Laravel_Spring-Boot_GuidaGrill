<?php

namespace App\Http\Controllers;

use App\Http\Requests\LoginUserRequest;
use App\Http\Resources\UserResource;
use App\Models\User;
use Illuminate\Http\Request;
use App\Http\Requests\UpdateUserRequest;
class UserController extends Controller
{
    protected User $user;
    /**
     * Display a listing of the resource.
     */
    public function index() //get all users
    {
        return UserResource::collection(User::all());
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        // 
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request) //create new user
    {
        $usernameExists = User::where('username', $request->input('username'))->exists();
        if ($usernameExists) {
            return response()->json([
                'message' => 'Username already exists'
            ], 400);
        }

        $emailExists = User::where('email', $request->input('email'))->exists();
        if ($emailExists) {
            return response()->json([
                'message' => 'Email already exists'
            ], 400);
        }
        $request->validate([
            'username' => 'required|string|unique:users',
            'password' => 'required|string',
            'email' => 'required|email|unique:users',
            'type' => 'required|string',
            'is_active' => 'required|boolean',
            'photo' => 'required|string',
        ]);
        $user = new User();

        // Llenar los campos del usuario
        $user->username = $request->input('username');
        $user->password = bcrypt($request->input('password'));
        $user->email = $request->input('email');
        $user->type = $request->input('type');
        $user->is_active = $request->input('is_active');
        $user->photo = $request->input('photo');

        // Guardar el usuario en la base de datos
        $user->save();

        return response()->json($user, 201);
    }

    /**
     * Display the specified resource.
     */
    // public function show($id) //get user by id
    // {
    //     return UserResource::collection(User::where('id', $id)->firstOrFail());
    // }
    public function show($id)
    {
        return UserResource::make(User::findOrFail($id));
    }


    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update( $request, $id)
    {
        $user = User::where('id', $id)->firstOrFail();
        if (isset($request->validated()['username'])) {
            $usernameExists = User::where('username', $request->validated()['username'])->exists();
            if ($usernameExists) {
                return response()->json([
                    'message' => 'Username already exists'
                ], 400);
            }
            $user->username = $request->validated()['username'];
        }
        if (isset($request->validated()['email'])) {
            $emailExists = User::where('email', $request->validated()['email'])->exists();
            if ($emailExists) {
                return response()->json([
                    'message' => 'Email already exists'
                ], 400);
            }
            $user->email = $request->validated()['email'];
        }
        if (isset($request->validated()['password'])) {
            $user->password = bcrypt($request->validated()['password']);
        }
        if (isset($request->validated()['is_active'])) {
            // Rest of the code...
        }
    
    


        $user->save();

        return response()->json([
            'message' => 'User updated successfully'
        ]);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $delete = User::where('id', $id)->delete();
        if ($delete) {
            return response()->json([
                'message' => 'User deleted successfully'
            ], 200);
        }
        return response()->json([
            'message' => 'User not found'
        ], 404);
    }

    public function login(LoginUserRequest $request)
    {
        $token = auth()->attempt($request->validated());
        if (!$token) {
            return response()->json([
                'message' => 'Invalid credentials'
            ], 400);
        }
        // if(auth()->user()->type != 'admin'){
        //     return response()->json([
        //         'message' => 'Invalid credentials'
        //     ], 400);
        // }
        return response()->json([
            'token' => $token,
            'user' => UserResource::make(auth()->user())
        ]);
    }
    public function logout()
    {
        try {
            if (auth()->user() === null) {
                return response()->json([
                    'error' => 'logout failed'
                ], 500);
            }
            auth()->logout();
            return response()->json([
                'message' => 'Logged out successfully'
            ]);
        } catch (\Throwable $th) {
            return response()->json([
                'error' => 'logout failed'
            ], 500);
        }
    }
    public function getUserToken()
    {
        try {
            return UserResource::make(auth()->user());
        } catch (\Throwable $th) {
            return response()->json([
                'error' => 'get user error'
            ], 401);
        }
    }
    public function isAdmin(){
        try {
            if(auth()-> user() == null || auth()->user()->type != 'admin'){
                return response()->json([
                    'error' => 'Not authorized'
                ], 401);
            }
            return response()->json([
                'message' => 'Authorized'
            ], 200);

        } catch (\Throwable $th) {
            return response()->json([
                'error' => 'Not authorized'
            ], 401);
        }
    }
}
