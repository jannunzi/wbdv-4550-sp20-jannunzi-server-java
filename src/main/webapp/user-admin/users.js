

(function() {
    let userService = new AdminUserServiceClient()

    let $userList
    let $usernameFld
    let $createBtn
    let $updateBtn

    let users = [
        {username: 'alice'},
        {username: 'bob'}
    ]

    function deleteUser(index) {
        let user = users[index]
        let userId = user._id

        userService.deleteUser(userId)
            .then(response => {
                users.splice(index, 1)
                renderUsers()
            })
    }

    function createUser() {
        const newUser = {
            username: $usernameFld.val()
        }
        $usernameFld.val("")

        userService.createUser(newUser)
            .then((actualUser) => {
                // users.push(actualUser)
                // renderUsers()
                findAllUsers()
            })
    }

    let currentUserIndex = -1
    function editUser(index) {
        currentUserIndex = index
        let user = users[index]
        let userId = user._id

        userService.findUserById(userId)
            .then(actualUser => {
                $usernameFld.val(actualUser.username)
            })
    }

    function updateUser() {
        const updatedUser = {
            username: $usernameFld.val()
        }
        $usernameFld.val("")
        updatedUser._id = users[currentUserIndex]._id

        userService.updateUser(updatedUser._id, updatedUser)
            .then((actualUser) => {
                findAllUsers()
            })
    }

    function renderUsers() {
        $userList.empty()
        for(let u in users) {
            let user = users[u]

            $deleteBtn = $("<button>Delete</button>")
            $deleteBtn.click(() => deleteUser(u))

            $editBtn = $("<button>Edit</button>")
            $editBtn.click(() => editUser(u))

            $li = $("<li>")
            $li.append($deleteBtn)
            $li.append($editBtn)
            $li.append(user.username)
            $userList.append($li)
        }
    }
    function findAllUsers() {
        userService
            .findAllUsers()
            .then(theusers => {
                users = theusers
                renderUsers()
            })
    }
    function main() {
        $userList = $("#userList")
        $usernameFld = $("#usernameFld")
        $createBtn = $("#createBtn")
        $createBtn.click(createUser)
        $updateBtn = $("#updateBtn")
        $updateBtn.click(updateUser)

        userService
            .findAllUsers()
            .then(theusers => {
                users = theusers
                renderUsers()
            })
    }
    $(main)
})()
